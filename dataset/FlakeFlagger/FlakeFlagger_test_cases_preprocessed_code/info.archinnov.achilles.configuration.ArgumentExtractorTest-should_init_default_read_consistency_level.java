@Test public void should_init_default_read_consistency_level() throws Exception {
assertThat(extractor.initDefaultReadConsistencyLevel(configMap)).isEqualTo(ONE);
}