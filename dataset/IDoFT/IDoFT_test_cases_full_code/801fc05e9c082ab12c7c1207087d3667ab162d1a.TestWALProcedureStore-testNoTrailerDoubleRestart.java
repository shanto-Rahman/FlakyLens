@Test public void testNoTrailerDoubleRestart() throws Exception {
  Procedure proc0=new TestSequentialProcedure();
  procStore.insert(proc0,null);
  Procedure proc1=new TestSequentialProcedure();
  procStore.insert(proc1,null);
  Procedure proc2=new TestSequentialProcedure();
  procStore.insert(proc2,null);
  procStore.rollWriterForTesting();
  procStore.delete(proc1.getProcId());
  procStore.rollWriterForTesting();
  procStore.update(proc2);
  procStore.rollWriterForTesting();
  procStore.delete(proc2.getProcId());
  procStore.stop(false);
  FileStatus[] logs=fs.listStatus(logDir);
  assertEquals(4,logs.length);
  for (int i=0; i < logs.length; ++i) {
    corruptLog(logs[i],4);
  }
  htu.getConfiguration().setBoolean(WALProcedureStore.EXEC_WAL_CLEANUP_ON_LOAD_CONF_KEY,false);
  LoadCounter loader=new LoadCounter();
  storeRestart(loader);
  assertEquals(1,loader.getLoadedCount());
  assertEquals(0,loader.getCorruptedCount());
  assertEquals(5,fs.listStatus(logDir).length);
  loader=new LoadCounter();
  storeRestart(loader);
  assertEquals(1,loader.getLoadedCount());
  assertEquals(0,loader.getCorruptedCount());
  procStore.delete(proc0.getProcId());
  procStore.periodicRollForTesting();
  assertEquals(1,fs.listStatus(logDir).length);
  storeRestart(loader);
}
