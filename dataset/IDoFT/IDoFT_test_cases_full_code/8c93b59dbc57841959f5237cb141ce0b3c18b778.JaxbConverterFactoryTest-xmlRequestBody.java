@Test public void xmlRequestBody() throws Exception {
  server.enqueue(new MockResponse());
  Call<Void> call=service.postXml(SAMPLE_CONTACT);
  call.execute();
  RecordedRequest request=server.takeRequest();
  assertThat(request.getHeader("Content-Type")).isEqualTo("application/xml; charset=utf-8");
  assertThat(request.getBody().readUtf8()).isEqualTo(SAMPLE_CONTACT_XML);
}
