@Test public void testSweep2Uncommitted() throws Exception {
assertFalse(isSweep2Necessary(ns));
assertFalse(DocumentNodeStoreSweepIT.isClean(ns2,"/node-1"));
assertTrue(ns2.backgroundSweep2(0));
assertFalse(DocumentNodeStoreSweepIT.isClean(ns2,"/node-1"));
}