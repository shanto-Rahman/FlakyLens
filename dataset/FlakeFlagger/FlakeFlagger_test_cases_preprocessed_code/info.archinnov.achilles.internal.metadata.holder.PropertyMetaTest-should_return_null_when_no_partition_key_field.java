@Test public void should_return_null_when_no_partition_key_field() throws Exception {
assertThat(idMeta.getPartitionKeyField()).isNull();
}