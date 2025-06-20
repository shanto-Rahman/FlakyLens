@Test public void testThreadpool() throws Exception {
assertThat(consumer.getThreadpool(),equalTo("fixed"));
}