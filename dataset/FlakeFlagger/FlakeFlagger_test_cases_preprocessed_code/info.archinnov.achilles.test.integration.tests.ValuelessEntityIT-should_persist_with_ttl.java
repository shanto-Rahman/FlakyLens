@Test public void should_persist_with_ttl() throws Exception {
Thread.sleep(1000);
assertThat(manager.find(ValuelessEntity.class,id)).isNull();
}