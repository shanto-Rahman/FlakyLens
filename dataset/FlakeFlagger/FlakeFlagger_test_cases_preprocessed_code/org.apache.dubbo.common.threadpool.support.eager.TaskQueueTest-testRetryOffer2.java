@Test public void testRetryOffer2() throws Exception {
assertThat(queue.retryOffer(mock(Runnable.class),1000,TimeUnit.MILLISECONDS),is(true));
}