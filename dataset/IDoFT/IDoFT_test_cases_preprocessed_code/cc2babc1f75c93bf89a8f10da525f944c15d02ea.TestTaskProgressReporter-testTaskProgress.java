@Test(timeout=10000) public void testTaskProgress() throws Exception {
t.start();
Thread.sleep(2100);
t.join();
Assert.assertEquals(statusUpdateTimes,2);//RW
}