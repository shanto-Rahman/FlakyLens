@Test void shouldHandleSingleHealthStateViewCorrectly() throws IOException {
assertThat(response.isHealthy()).isTrue();
assertThat(response.getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
assertThat(response.getMessage()).isEqualToIgnoringWhitespace(fixture("/json/single-healthy-response.json"));
}