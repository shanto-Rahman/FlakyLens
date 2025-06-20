@Config(sdk=24) @Test public void optionalApi24() throws IOException {
  server.enqueue(new MockResponse());
  Optional<Object> optional=service.optional().execute().body();
  assertThat(optional).isNotNull();
  assertThat(optional.get()).isSameAs(ObjectInstanceConverterFactory.VALUE);
}
