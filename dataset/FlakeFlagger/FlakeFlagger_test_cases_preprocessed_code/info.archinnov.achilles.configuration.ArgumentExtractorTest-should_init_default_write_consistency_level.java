@Test public void should_init_default_write_consistency_level() throws Exception {
assertThat(extractor.initDefaultWriteConsistencyLevel(configMap)).isEqualTo(LOCAL_QUORUM);
}