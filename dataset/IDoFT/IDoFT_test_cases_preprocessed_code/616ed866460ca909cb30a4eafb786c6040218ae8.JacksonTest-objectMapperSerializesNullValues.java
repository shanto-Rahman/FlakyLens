@Test public void objectMapperSerializesNullValues() throws IOException {
assertThat(mapper.writeValueAsString(pojo)).isEqualTo(json);
}