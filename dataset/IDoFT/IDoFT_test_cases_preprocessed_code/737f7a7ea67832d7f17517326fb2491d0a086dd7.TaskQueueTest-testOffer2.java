@Test public void testOffer2() throws Exception {
assertThat(queue.offer(mock(Runnable.class)),is(true));
}