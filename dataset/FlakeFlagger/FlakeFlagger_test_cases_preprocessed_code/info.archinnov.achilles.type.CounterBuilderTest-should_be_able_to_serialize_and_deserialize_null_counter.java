@Test public void should_be_able_to_serialize_and_deserialize_null_counter() throws Exception {
assertThat(serialized).isEqualTo("\"\"");
assertThat(serialized).isEqualTo("null");
assertThat(deserialized).isNull();
}