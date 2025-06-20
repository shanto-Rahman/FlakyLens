@Test public void should_return_null_for_partition_key_if_not_embedded_id() throws Exception {
assertThat(invoker.getPartitionKey(embeddedKey,idMeta)).isNull();
}