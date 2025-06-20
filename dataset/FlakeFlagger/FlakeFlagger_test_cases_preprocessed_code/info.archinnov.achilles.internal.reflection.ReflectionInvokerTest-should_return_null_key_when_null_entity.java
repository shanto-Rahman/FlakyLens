@Test public void should_return_null_key_when_null_entity() throws Exception {
assertThat(invoker.getPrimaryKey(null,idMeta)).isNull();
}