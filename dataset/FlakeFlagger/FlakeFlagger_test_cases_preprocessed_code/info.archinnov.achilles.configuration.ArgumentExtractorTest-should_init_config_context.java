@Test public void should_init_config_context() throws Exception {
assertThat(configContext.isForceColumnFamilyCreation()).isTrue();
assertThat(configContext.getObjectMapperFactory()).isSameAs(factory);
assertThat(configContext.getDefaultReadConsistencyLevel()).isEqualTo(ANY);
assertThat(configContext.getDefaultWriteConsistencyLevel()).isEqualTo(ALL);
assertThat(configContext.getDefaultWriteConsistencyLevel()).isEqualTo(ALL);
assertThat(configContext.getBeanValidator()).isNull();
assertThat(configContext.getPreparedStatementLRUCacheSize()).isEqualTo(DEFAULT_LRU_CACHE_SIZE);
assertThat(configContext.getInsertStrategy()).isEqualTo(ALL_FIELDS);
assertThat(configContext.getInsertStrategy()).isEqualTo(ALL_FIELDS);
}