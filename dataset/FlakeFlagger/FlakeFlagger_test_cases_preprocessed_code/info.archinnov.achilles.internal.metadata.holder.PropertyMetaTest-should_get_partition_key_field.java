@Test public void should_get_partition_key_field() throws Exception {
assertThat(idMeta.getPartitionKeyField()).isEqualTo(idField);
}