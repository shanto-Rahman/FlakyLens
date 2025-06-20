@Test public void testLostMasterLockAfterThreshold() throws Exception {
Assert.assertEquals(100,sl.getStartLevel());
Thread.sleep(5000);
Assert.assertEquals(1,sl.getStartLevel());
Thread.sleep(1000);
Thread.sleep(1000);
}