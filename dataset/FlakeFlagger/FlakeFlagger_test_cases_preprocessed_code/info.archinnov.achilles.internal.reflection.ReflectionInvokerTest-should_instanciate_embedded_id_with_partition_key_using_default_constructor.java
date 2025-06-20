@Test public void should_instanciate_embedded_id_with_partition_key_using_default_constructor() throws Exception {
assertThat(actual).isNotNull();
assertThat(embeddedKey.getUserId()).isEqualTo(partitionKey);
assertThat(embeddedKey.getName()).isNull();
}