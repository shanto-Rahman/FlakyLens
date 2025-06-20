@Test public void testJoin() throws RemotingException, InterruptedException {
countDownLatch.countDown();
long count=countDownLatch.getCount();
if (count > 0) {
}
TimeUnit.MILLISECONDS.sleep(50);
assertThat(lookup,not(nullValue()));
}