@Test public void userSuppliedJaxbContext() throws Exception {
  JAXBContext context=JAXBContext.newInstance(Contact.class);
  JaxbConverterFactory factory=JaxbConverterFactory.create(context);
  Retrofit retrofit=new Retrofit.Builder().baseUrl(server.url("/")).addConverterFactory(factory).build();
  service=retrofit.create(Service.class);
  server.enqueue(new MockResponse());
  Call<Void> call=service.postXml(SAMPLE_CONTACT);
  call.execute();
  RecordedRequest request=server.takeRequest();
  assertThat(request.getHeader("Content-Type")).isEqualTo("application/xml; charset=utf-8");
  assertThat(request.getBody().readUtf8()).isEqualTo(SAMPLE_CONTACT_XML);
}
