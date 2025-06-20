@Test public void testJoin() throws RemotingException, InterruptedException {
countDownLatch.countDown();
TimeUnit.MILLISECONDS.sleep(50);
long count=countDownLatch.getCount();
if (count > 0) {
}
assertThat(lookup,not(nullValue()));
assertThat(peer1,instanceOf(ExchangeServerPeer.class));
}