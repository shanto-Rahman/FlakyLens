@Test public void should_set_consistency_level() throws Exception {
assertThat(builder.buildClusterQuery().getConsistencyLevel()).isEqualTo(EACH_QUORUM);
}