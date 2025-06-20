@Test public void testSweep2Uncommitted() throws Exception {
  MemoryDocumentStore store=new MemoryDocumentStore();
  FailingDocumentStore fStore=new FailingDocumentStore(store,42);
  DocumentNodeStore ns=builderProvider.newBuilder().setAsyncDelay(0).setClusterId(1).setDocumentStore(fStore).build();
  assertFalse(isSweep2Necessary(ns));
  DocumentNodeStoreSweepIT.createUncommittedChanges(ns,fStore);
  DocumentNodeStore ns2=Sweep2TestHelper.applyPre18Aging(fStore,withAsyncDelay(builderProvider,0),2);
  Sweep2TestHelper.removeSweep2Status(fStore);
  assertFalse(DocumentNodeStoreSweepIT.isClean(ns2,"/node-1"));
  assertTrue(ns2.backgroundSweep2(0));
  assertFalse(DocumentNodeStoreSweepIT.isClean(ns2,"/node-1"));
}
