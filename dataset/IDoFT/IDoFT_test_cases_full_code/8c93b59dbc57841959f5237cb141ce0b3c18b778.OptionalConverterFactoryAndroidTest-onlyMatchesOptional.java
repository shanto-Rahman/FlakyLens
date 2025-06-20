@Test public void onlyMatchesOptional() throws IOException {
  server.enqueue(new MockResponse());
  Object body=service.object().execute().body();
  assertThat(body).isSameAs(ObjectInstanceConverterFactory.VALUE);
}
