@Test public void testHappyPathWithCustomQueryParametersFromFlowFile() throws Exception {
  testRunner.setProperty(PutSplunkHTTP.SOURCE,"${ff_source}");
  testRunner.setProperty(PutSplunkHTTP.SOURCE_TYPE,"${ff_source_type}");
  testRunner.setProperty(PutSplunkHTTP.HOST,"${ff_host}");
  testRunner.setProperty(PutSplunkHTTP.INDEX,"${ff_index}");
  testRunner.setProperty(PutSplunkHTTP.CHARSET,"${ff_charset}");
  testRunner.setProperty(PutSplunkHTTP.CONTENT_TYPE,"${ff_content_type}");
  givenSplunkReturnsWithSuccess();
  final Map<String,String> attributes=new HashMap<>();
  attributes.put("ff_source","test_source");
  attributes.put("ff_source_type","test?source?type");
  attributes.put("ff_host","test_host");
  attributes.put("ff_index","test_index");
  attributes.put("ff_charset","UTF-8");
  attributes.put("ff_content_type","test_content_type");
  final MockFlowFile incomingFlowFile=new MockFlowFile(1);
  incomingFlowFile.putAttributes(attributes);
  incomingFlowFile.setData(EVENT.getBytes(StandardCharsets.UTF_8));
  testRunner.enqueue(incomingFlowFile);
  testRunner.run();
  testRunner.assertAllFlowFilesTransferred(PutSplunkHTTP.RELATIONSHIP_SUCCESS,1);
  Assert.assertEquals("/services/collector/raw?host=test_host&index=test_index&sourcetype=test%3Fsource%3Ftype&source=test_source",path.getValue());
  Assert.assertEquals(EVENT,processor.getLastContent());
  Assert.assertEquals(attributes.get("ff_content_type"),processor.getLastContentType());
}
