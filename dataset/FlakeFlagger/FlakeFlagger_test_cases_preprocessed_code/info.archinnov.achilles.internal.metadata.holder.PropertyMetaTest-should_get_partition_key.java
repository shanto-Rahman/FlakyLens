@Test public void should_get_partition_key() throws Exception {
assertThat(pm.getPartitionKey(embeddedKey)).isEqualTo(id);
}