@Test(timeout=10000) public void testTaskProgress() throws Exception {
statusUpdateTimes=0;//RW
t.start();
Thread.sleep(2100);
t.join();
assertThat(statusUpdateTimes).isEqualTo(2);//RW
}