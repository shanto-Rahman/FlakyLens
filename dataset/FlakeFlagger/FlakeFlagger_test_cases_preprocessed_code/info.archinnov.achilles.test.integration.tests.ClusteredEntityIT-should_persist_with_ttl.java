@Test public void should_persist_with_ttl() throws Exception {
assertThat(manager.find(ClusteredEntity.class,compoundKey)).isNotNull();
Thread.sleep(1000);
assertThat(manager.find(ClusteredEntity.class,compoundKey)).isNull();
}