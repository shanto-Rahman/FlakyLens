@Test public void testLoad() throws Exception {
  Set<Long> procIds=new HashSet<>();
  Procedure proc1=new TestSequentialProcedure();
  procIds.add(proc1.getProcId());
  procStore.insert(proc1,null);
  Procedure proc2=new TestSequentialProcedure();
  Procedure[] child2=new Procedure[2];
  child2[0]=new TestSequentialProcedure();
  child2[1]=new TestSequentialProcedure();
  procIds.add(proc2.getProcId());
  procIds.add(child2[0].getProcId());
  procIds.add(child2[1].getProcId());
  procStore.insert(proc2,child2);
  verifyProcIdsOnRestart(procIds);
  procStore.update(proc1);
  procStore.update(child2[1]);
  procStore.delete(child2[1].getProcId());
  procIds.remove(child2[1].getProcId());
  verifyProcIdsOnRestart(procIds);
  procStore.stop(false);
  FileStatus[] logs=fs.listStatus(logDir);
  assertEquals(3,logs.length);
  for (int i=0; i < logs.length; ++i) {
    corruptLog(logs[i],4);
  }
  verifyProcIdsOnRestart(procIds);
}
