@Test public void testHappyPathWithCustomQueryParameters() throws Exception {
  testRunner.setProperty(PutSplunkHTTP.SOURCE,"test_source");
  testRunner.setProperty(PutSplunkHTTP.SOURCE_TYPE,"test?source?type");
  givenSplunkReturnsWithSuccess();
  testRunner.enqueue(EVENT);
  testRunner.run();
  testRunner.assertAllFlowFilesTransferred(PutSplunkHTTP.RELATIONSHIP_SUCCESS,1);
  Assert.assertEquals("/services/collector/raw?sourcetype=test%3Fsource%3Ftype&source=test_source",path.getValue());
}
