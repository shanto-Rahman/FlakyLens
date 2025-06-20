@Test public void testThreads() throws Exception {
assertThat(consumer.getThreads(),equalTo(20));
}