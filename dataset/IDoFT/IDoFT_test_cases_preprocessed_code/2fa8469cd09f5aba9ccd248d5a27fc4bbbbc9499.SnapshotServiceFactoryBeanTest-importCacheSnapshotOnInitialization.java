@Test public void importCacheSnapshotOnInitialization() throws Exception {
assertThat(factoryBean.getObject(),is(nullValue()));
assertThat((Class<SnapshotServiceAdapter>)factoryBean.getObjectType(),is(equalTo(SnapshotServiceAdapter.class)));
assertThat(factoryBean.getObject(),is(instanceOf(CacheSnapshotServiceAdapter.class)));
assertThat((Class<CacheSnapshotServiceAdapter>)factoryBean.getObjectType(),is(equalTo(CacheSnapshotServiceAdapter.class)));
}