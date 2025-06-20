@Test public void testBindWithAlias() throws Exception {
assertThat(target.getFooBaz(),equalTo("a"));
assertThat(target.getFoo(),equalTo("b"));
}