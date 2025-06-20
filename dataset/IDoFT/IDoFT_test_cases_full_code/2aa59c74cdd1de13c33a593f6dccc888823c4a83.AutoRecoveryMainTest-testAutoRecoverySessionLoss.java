/** 
 * Test that, if an autorecovery looses its ZK connection/session it will shutdown.
 */
@Test public void testAutoRecoverySessionLoss() throws Exception {
  AutoRecoveryMain main1=new AutoRecoveryMain(confByIndex(0));
  AutoRecoveryMain main2=new AutoRecoveryMain(confByIndex(1));
  AutoRecoveryMain main3=new AutoRecoveryMain(confByIndex(2));
  ZKMetadataClientDriver zkMetadataClientDriver1=startAutoRecoveryMain(main1);
  ZooKeeper zk1=zkMetadataClientDriver1.getZk();
  for (int i=0; i < 10; i++) {
    try {
      if (main1.auditorElector.getCurrentAuditor() != null) {
        break;
      }
 else {
        Thread.sleep(1000);
      }
    }
 catch (    IOException e) {
      Thread.sleep(1000);
    }
  }
  BookieId currentAuditor=main1.auditorElector.getCurrentAuditor();
  assertNotNull(currentAuditor);
  Auditor auditor1=main1.auditorElector.getAuditor();
  assertTrue("Current Auditor should be AR1",currentAuditor.equals(BookieImpl.getBookieId(confByIndex(0))));
  assertTrue("Auditor of AR1 should be running",auditor1.isRunning());
  ZKMetadataClientDriver zkMetadataClientDriver2=startAutoRecoveryMain(main2);
  ZooKeeper zk2=zkMetadataClientDriver2.getZk();
  ZKMetadataClientDriver zkMetadataClientDriver3=startAutoRecoveryMain(main3);
  ZooKeeper zk3=zkMetadataClientDriver3.getZk();
  assertTrue("Current Auditor should still be AR1",currentAuditor.equals(BookieImpl.getBookieId(confByIndex(0))));
  Auditor auditor2=main2.auditorElector.getAuditor();
  Auditor auditor3=main3.auditorElector.getAuditor();
  assertTrue("AR2's Auditor should not be running",(auditor2 == null || !auditor2.isRunning()));
  assertTrue("AR3's Auditor should not be running",(auditor3 == null || !auditor3.isRunning()));
  zkUtil.expireSession(zk2);
  zkUtil.expireSession(zk1);
  for (int i=0; i < 10; i++) {
    if (!main1.auditorElector.isRunning() && !main1.replicationWorker.isRunning() && !main1.isAutoRecoveryRunning()&& !main2.auditorElector.isRunning()&& !main2.replicationWorker.isRunning()&& !main2.isAutoRecoveryRunning()) {
      break;
    }
    Thread.sleep(1000);
  }
  currentAuditor=main3.auditorElector.getCurrentAuditor();
  assertTrue("Current Auditor should be AR3",currentAuditor.equals(BookieImpl.getBookieId(confByIndex(2))));
  auditor3=main3.auditorElector.getAuditor();
  assertTrue("Auditor of AR3 should be running",auditor3.isRunning());
  assertFalse("AR1's auditor should not be running",auditor1.isRunning());
  assertFalse("Elector1 should have shutdown",main1.auditorElector.isRunning());
  assertFalse("RW1 should have shutdown",main1.replicationWorker.isRunning());
  assertFalse("AR1 should have shutdown",main1.isAutoRecoveryRunning());
  assertFalse("Elector2 should have shutdown",main2.auditorElector.isRunning());
  assertFalse("RW2 should have shutdown",main2.replicationWorker.isRunning());
  assertFalse("AR2 should have shutdown",main2.isAutoRecoveryRunning());
}
