@Test public void testMultipleContainerReader() throws Exception {
  final int volumeNum=10;
  StringBuffer datanodeDirs=new StringBuffer();
  File[] volumeDirs=new File[volumeNum];
  for (int i=0; i < volumeNum; i++) {
    volumeDirs[i]=tempDir.newFolder();
    datanodeDirs=datanodeDirs.append(volumeDirs[i]).append(",");
  }
  conf.set(ScmConfigKeys.HDDS_DATANODE_DIR_KEY,datanodeDirs.toString());
  conf.set(OzoneConfigKeys.DFS_CONTAINER_RATIS_DATANODE_STORAGE_DIR,datanodeDirs.toString());
  MutableVolumeSet volumeSets=new MutableVolumeSet(datanodeId.toString(),clusterId,conf,null,StorageVolume.VolumeType.DATA_VOLUME,null);
  ContainerCache cache=ContainerCache.getInstance(conf);
  cache.clear();
  RoundRobinVolumeChoosingPolicy policy=new RoundRobinVolumeChoosingPolicy();
  final int containerCount=100;
  blockCount=containerCount;
  for (int i=0; i < containerCount; i++) {
    KeyValueContainerData keyValueContainerData=new KeyValueContainerData(i,ChunkLayOutVersion.FILE_PER_BLOCK,(long)StorageUnit.GB.toBytes(5),UUID.randomUUID().toString(),datanodeId.toString());
    KeyValueContainer keyValueContainer=new KeyValueContainer(keyValueContainerData,conf);
    keyValueContainer.create(volumeSets,policy,clusterId);
    List<Long> blkNames;
    if (i % 2 == 0) {
      blkNames=addBlocks(keyValueContainer,true);
      markBlocksForDelete(keyValueContainer,true,blkNames,i);
    }
 else {
      blkNames=addBlocks(keyValueContainer,false);
      markBlocksForDelete(keyValueContainer,false,blkNames,i);
    }
    BlockUtils.removeDB(keyValueContainerData,conf);
  }
  List<StorageVolume> volumes=volumeSets.getVolumesList();
  ContainerReader[] containerReaders=new ContainerReader[volumeNum];
  Thread[] threads=new Thread[volumeNum];
  for (int i=0; i < volumeNum; i++) {
    containerReaders[i]=new ContainerReader(volumeSets,(HddsVolume)volumes.get(i),containerSet,conf);
    threads[i]=new Thread(containerReaders[i]);
  }
  long startTime=System.currentTimeMillis();
  for (int i=0; i < volumeNum; i++) {
    threads[i].start();
  }
  for (int i=0; i < volumeNum; i++) {
    threads[i].join();
  }
  System.out.println("Open " + volumeNum + " Volume with "+ containerCount+ " costs "+ (System.currentTimeMillis() - startTime) / 1000 + "s");
  Assert.assertEquals(containerCount,containerSet.getContainerMap().entrySet().size());
  Assert.assertEquals(0,cache.size());
}
