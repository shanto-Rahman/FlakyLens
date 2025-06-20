@Test public void should_remove_by_id() throws Exception {
assertThat(manager.find(ClusteredEntityWithCompositePartitionKey.class,compoundKey)).isNull();
}