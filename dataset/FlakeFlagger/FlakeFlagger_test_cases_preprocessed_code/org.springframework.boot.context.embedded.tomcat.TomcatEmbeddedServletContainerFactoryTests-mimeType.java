@Test public void mimeType() throws Exception {
assertThat(response.getHeaders().getContentType().toString(),equalTo("text/css"));
}