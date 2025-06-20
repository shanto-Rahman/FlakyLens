@Test public void testOrder() throws Exception {
assertThat(ordered.get(0),equalTo(CloudAutoConfiguration.class.getName()));
}