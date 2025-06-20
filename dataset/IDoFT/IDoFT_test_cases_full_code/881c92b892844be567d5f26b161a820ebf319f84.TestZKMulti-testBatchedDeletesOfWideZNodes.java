@Test public void testBatchedDeletesOfWideZNodes() throws Exception {
  final int batchSize=50;
  Configuration localConf=new Configuration(TEST_UTIL.getConfiguration());
  localConf.setInt("zookeeper.multi.max.size",batchSize);
  try (ZKWatcher customZkw=new ZKWatcher(localConf,"TestZKMulti_Custom",new ZKMultiAbortable(),true)){
    final String parent1="/batchedDeletes1";
    final String parent2="/batchedDeletes2";
    final byte[] EMPTY_BYTES=new byte[0];
    List<Op> ops=new ArrayList<>();
    ops.add(Op.create(parent1,EMPTY_BYTES,Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT));
    for (int i=0; i < batchSize * 2; i++) {
      ops.add(Op.create(parent1 + "/" + i,EMPTY_BYTES,Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT));
    }
    customZkw.getRecoverableZooKeeper().multi(ops);
    ops.clear();
    ops.add(Op.create(parent2,EMPTY_BYTES,Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT));
    for (int i=0; i < batchSize * 4; i++) {
      ops.add(Op.create(parent2 + "/" + i,EMPTY_BYTES,Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT));
    }
    customZkw.getRecoverableZooKeeper().multi(ops);
    ZKUtil.deleteChildrenRecursively(customZkw,parent1);
    ZKUtil.deleteChildrenRecursively(customZkw,parent2);
  }
 }
