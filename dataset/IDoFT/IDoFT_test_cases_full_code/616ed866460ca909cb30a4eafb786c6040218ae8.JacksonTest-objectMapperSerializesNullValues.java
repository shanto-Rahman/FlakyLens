@Test public void objectMapperSerializesNullValues() throws IOException {
  final ObjectMapper mapper=Jackson.newObjectMapper();
  final Issue1627 pojo=new Issue1627(null,null);
  final String json="{\"string\":null,\"uuid\":null}";
  assertThat(mapper.writeValueAsString(pojo)).isEqualTo(json);
}
