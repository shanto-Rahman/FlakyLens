@Test public void should_set_limit() throws Exception {
assertThat(builder.buildClusterQuery().getLimit()).isEqualTo(53);
}