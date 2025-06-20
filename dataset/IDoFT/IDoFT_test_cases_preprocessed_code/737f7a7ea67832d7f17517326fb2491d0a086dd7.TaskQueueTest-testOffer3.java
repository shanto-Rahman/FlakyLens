@Test public void testOffer3() throws Exception {
assertThat(queue.offer(mock(Runnable.class)),is(false));
}