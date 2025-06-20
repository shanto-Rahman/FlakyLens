@Test public void testOffer4() throws Exception {
assertThat(queue.offer(mock(Runnable.class)),is(true));
}