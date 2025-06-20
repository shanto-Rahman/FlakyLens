@Test public void testJoin() throws RemotingException, InterruptedException, IOException {
countDownLatch.countDown();
long count=countDownLatch.getCount();
if (count > 0) {
}
TimeUnit.MILLISECONDS.sleep(50);
}