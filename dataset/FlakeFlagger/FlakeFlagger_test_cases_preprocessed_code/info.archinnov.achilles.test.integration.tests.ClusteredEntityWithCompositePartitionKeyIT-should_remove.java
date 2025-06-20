@Test public void should_remove() throws Exception {
assertThat(manager.find(ClusteredEntityWithCompositePartitionKey.class,compoundKey)).isNull();
}