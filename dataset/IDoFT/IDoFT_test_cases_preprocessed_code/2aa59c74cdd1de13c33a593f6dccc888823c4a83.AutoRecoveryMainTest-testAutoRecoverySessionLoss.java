/** 
 * Test that, if an autorecovery looses its ZK connection/session it will shutdown.
 */
@Test public void testAutoRecoverySessionLoss() throws Exception {
if (main1.auditorElector.getCurrentAuditor() != null) {
Thread.sleep(1000);
}
Thread.sleep(1000);
assertNotNull(currentAuditor);
assertTrue("Current Auditor should be AR1",currentAuditor.equals(BookieImpl.getBookieId(confByIndex(0))));
assertTrue("Auditor of AR1 should be running",auditor1.isRunning());
assertTrue("Current Auditor should still be AR1",currentAuditor.equals(BookieImpl.getBookieId(confByIndex(0))));
assertTrue("AR2's Auditor should not be running",(auditor2 == null || !auditor2.isRunning()));
assertTrue("AR3's Auditor should not be running",(auditor3 == null || !auditor3.isRunning()));
if (!main1.auditorElector.isRunning() && !main1.replicationWorker.isRunning() && !main1.isAutoRecoveryRunning()&& !main2.auditorElector.isRunning()&& !main2.replicationWorker.isRunning()&& !main2.isAutoRecoveryRunning()) {
}
Thread.sleep(1000);
assertTrue("Current Auditor should be AR3",currentAuditor.equals(BookieImpl.getBookieId(confByIndex(2))));
assertTrue("Auditor of AR3 should be running",auditor3.isRunning());
assertFalse("AR1's auditor should not be running",auditor1.isRunning());
assertFalse("Elector1 should have shutdown",main1.auditorElector.isRunning());
assertFalse("RW1 should have shutdown",main1.replicationWorker.isRunning());
assertFalse("AR1 should have shutdown",main1.isAutoRecoveryRunning());
assertFalse("Elector2 should have shutdown",main2.auditorElector.isRunning());
assertFalse("RW2 should have shutdown",main2.replicationWorker.isRunning());
assertFalse("AR2 should have shutdown",main2.isAutoRecoveryRunning());
}