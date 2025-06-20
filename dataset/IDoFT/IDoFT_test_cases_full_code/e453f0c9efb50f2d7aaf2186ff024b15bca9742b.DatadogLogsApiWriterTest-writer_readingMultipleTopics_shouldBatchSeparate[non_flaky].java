@Test public void writer_readingMultipleTopics_shouldBatchSeparate() throws IOException {
  DatadogLogsSinkConnectorConfig config=new DatadogLogsSinkConnectorConfig(false,2,props);
  DatadogLogsApiWriter writer=new DatadogLogsApiWriter(config);
  records.add(new SinkRecord("someTopic1",0,null,"someKey",null,"someValue1",0));
  records.add(new SinkRecord("someTopic2",0,null,"someKey",null,"someValue2",0));
  writer.write(records);
  Assert.assertEquals(2,restHelper.getCapturedRequests().size());
  RequestInfo request1=restHelper.getCapturedRequests().get(0);
  RequestInfo request2=restHelper.getCapturedRequests().get(1);
  Set<String> requestBodySetActual=new HashSet<>();
  requestBodySetActual.add(request1.getBody());
  requestBodySetActual.add(request2.getBody());
  Set<String> requestBodySetExpected=new HashSet<>();
  requestBodySetExpected.add("[{\"message\":\"someValue1\",\"ddsource\":\"kafka-connect\",\"ddtags\":\"topic:someTopic1\"}]");
  requestBodySetExpected.add("[{\"message\":\"someValue2\",\"ddsource\":\"kafka-connect\",\"ddtags\":\"topic:someTopic2\"}]");
  Assert.assertEquals(requestBodySetExpected,requestBodySetActual);
}
