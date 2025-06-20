@Test public void testContainerReaderWithLoadException() throws Exception {
  MutableVolumeSet volumeSet1;
  HddsVolume hddsVolume1;
  ContainerSet containerSet1=new ContainerSet();
  File volumeDir1=tempDir.newFolder();
  RoundRobinVolumeChoosingPolicy volumeChoosingPolicy1;
  volumeSet1=Mockito.mock(MutableVolumeSet.class);
  UUID datanode=UUID.randomUUID();
  hddsVolume1=new HddsVolume.Builder(volumeDir1.getAbsolutePath()).conf(conf).datanodeUuid(datanode.toString()).clusterID(clusterId).build();
  volumeChoosingPolicy1=mock(RoundRobinVolumeChoosingPolicy.class);
  Mockito.when(volumeChoosingPolicy1.chooseVolume(anyList(),anyLong())).thenReturn(hddsVolume1);
  int containerCount=3;
  for (int i=0; i < containerCount; i++) {
    KeyValueContainerData keyValueContainerData=new KeyValueContainerData(i,ChunkLayOutVersion.FILE_PER_BLOCK,(long)StorageUnit.GB.toBytes(5),UUID.randomUUID().toString(),datanodeId.toString());
    KeyValueContainer keyValueContainer=new KeyValueContainer(keyValueContainerData,conf);
    keyValueContainer.create(volumeSet1,volumeChoosingPolicy1,clusterId);
    BlockUtils.removeDB(keyValueContainerData,conf);
    if (i == 0) {
      String containerPathStr=keyValueContainer.getContainerData().getContainerPath();
      File containerPath=new File(containerPathStr);
      String renamePath=containerPathStr + "-aa";
      Assert.assertTrue(containerPath.renameTo(new File(renamePath)));
    }
  }
  ContainerReader containerReader=new ContainerReader(volumeSet1,hddsVolume1,containerSet1,conf);
  containerReader.readVolume(hddsVolume1.getHddsRootDir());
  Assert.assertEquals(containerCount - 1,containerSet1.containerCount());
}
