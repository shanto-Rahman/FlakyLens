/** 
 * Test whether  {@link HttpContent} is created from the list of {@link SplunkEvent}s. 
 */
@Test public void contentTest() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException, CertificateException, IOException {
  HttpEventPublisher publisher=HttpEventPublisher.newBuilder().withUrl("http://example.com").withToken("test-token").withDisableCertificateValidation(false).build();
  String expectedString="{\"time\":12345,\"host\":\"test-host-1\",\"source\":\"test-source-1\"," + "\"sourcetype\":\"test-source-type-1\",\"index\":\"test-index-1\"," + "\"event\":\"test-event-1\"}{\"time\":12345,\"host\":\"test-host-2\","+ "\"source\":\"test-source-2\",\"sourcetype\":\"test-source-type-2\","+ "\"index\":\"test-index-2\",\"event\":\"test-event-2\"}";
  try (ByteArrayOutputStream bos=new ByteArrayOutputStream()){
    HttpContent actualContent=publisher.getContent(SPLUNK_EVENTS);
    actualContent.writeTo(bos);
    String actualString=new String(bos.toByteArray(),StandardCharsets.UTF_8);
    assertThat(actualString,is(equalTo(expectedString)));
  }
 }
