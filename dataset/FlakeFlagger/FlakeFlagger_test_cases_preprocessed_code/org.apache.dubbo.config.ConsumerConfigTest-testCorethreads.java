@Test public void testCorethreads() throws Exception {
assertThat(consumer.getCorethreads(),equalTo(10));
}