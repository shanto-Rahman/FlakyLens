/** 
 * Test whether payload is stringified as expected. 
 */
@Test public void stringPayloadTest() throws UnsupportedEncodingException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, CertificateException, IOException {
  HttpEventPublisher publisher=HttpEventPublisher.newBuilder().withUrl("http://example.com").withToken("test-token").withDisableCertificateValidation(false).build();
  String actual=publisher.getStringPayload(SPLUNK_EVENTS);
  String expected="{\"time\":12345,\"host\":\"test-host-1\",\"source\":\"test-source-1\"," + "\"sourcetype\":\"test-source-type-1\",\"index\":\"test-index-1\"," + "\"event\":\"test-event-1\"}{\"time\":12345,\"host\":\"test-host-2\","+ "\"source\":\"test-source-2\",\"sourcetype\":\"test-source-type-2\","+ "\"index\":\"test-index-2\",\"event\":\"test-event-2\"}";
  assertThat(expected,is(equalTo(actual)));
}
