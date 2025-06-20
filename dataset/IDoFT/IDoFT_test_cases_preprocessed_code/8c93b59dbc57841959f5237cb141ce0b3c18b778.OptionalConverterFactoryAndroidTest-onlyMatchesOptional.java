@Test public void onlyMatchesOptional() throws IOException {
assertThat(body).isSameAs(ObjectInstanceConverterFactory.VALUE);
}