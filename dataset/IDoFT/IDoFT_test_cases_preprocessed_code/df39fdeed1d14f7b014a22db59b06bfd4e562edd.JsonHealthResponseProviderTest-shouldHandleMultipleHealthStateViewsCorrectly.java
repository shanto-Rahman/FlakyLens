@Test void shouldHandleMultipleHealthStateViewsCorrectly() throws IOException {
assertThat(response.isHealthy()).isTrue();
assertThat(response.getContentType()).isEqualTo(MediaType.APPLICATION_JSON);
assertThat(response.getMessage()).isEqualToIgnoringWhitespace(fixture("/json/multiple-healthy-responses.json"));
}