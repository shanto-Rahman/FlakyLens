@Test public void should_set_ordering() throws Exception {
assertThat(builder.buildClusterQuery().getOrdering()).isEqualTo(ASCENDING);
}