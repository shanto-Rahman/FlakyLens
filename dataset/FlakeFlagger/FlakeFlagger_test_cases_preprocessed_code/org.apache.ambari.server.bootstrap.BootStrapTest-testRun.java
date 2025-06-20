@Test public void testRun() throws Exception {
LOG.info("Bootdir is " + bootdir);//RW
LOG.info("Response id from bootstrap " + response.getRequestId());//RW
LOG.info("Status " + status.getStatus());//RW
Thread.sleep(100);
LOG.info("Status: log " + status.getLog() + " status="+ status.getStatus());//RW
Assert.assertTrue(status.getLog().contains("host1,host2"));
Assert.assertEquals(BSStat.SUCCESS,status.getStatus());
}