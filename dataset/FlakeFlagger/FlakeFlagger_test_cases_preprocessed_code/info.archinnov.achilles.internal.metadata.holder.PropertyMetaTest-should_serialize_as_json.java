@Test public void should_serialize_as_json() throws Exception {
assertThat(pm.forceEncodeToJSON(new UUID(10,10))).isEqualTo("\"00000000-0000-000a-0000-00000000000a\"");
}