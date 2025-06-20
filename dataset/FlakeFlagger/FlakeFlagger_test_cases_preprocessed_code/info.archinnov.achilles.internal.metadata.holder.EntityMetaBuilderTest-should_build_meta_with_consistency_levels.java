@Test public void should_build_meta_with_consistency_levels() throws Exception {
assertThat(meta.getConsistencyLevels()).isSameAs(consistencyLevels);
}