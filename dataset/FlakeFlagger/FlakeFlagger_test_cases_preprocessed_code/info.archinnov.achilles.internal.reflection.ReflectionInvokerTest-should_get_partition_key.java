@Test public void should_get_partition_key() throws Exception {
assertThat(invoker.getPartitionKey(embeddedKey,idMeta)).isEqualTo(partitionKey);
}