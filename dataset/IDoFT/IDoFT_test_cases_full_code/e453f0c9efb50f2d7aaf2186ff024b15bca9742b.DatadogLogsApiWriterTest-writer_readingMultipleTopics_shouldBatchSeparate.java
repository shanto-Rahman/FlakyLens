@Test public void writer_readingMultipleTopics_shouldBatchSeparate() throws IOException {
  config=new DatadogLogsSinkConnectorConfig(false,"localhost:8080",2,props);
  writer=new DatadogLogsApiWriter(config);
  records.add(new SinkRecord("someTopic1",0,null,"someKey",null,"someValue1",0));
  records.add(new SinkRecord("someTopic2",0,null,"someKey",null,"someValue2",0));
  writer.write(records);
  Assert.assertEquals(2,restHelper.getCapturedRequests().size());
  RequestInfo request1=restHelper.getCapturedRequests().get(0);
  RequestInfo request2=restHelper.getCapturedRequests().get(1);
  Assert.assertEquals("[{\"message\":\"someValue1\",\"ddsource\":\"kafka-connect\",\"ddtags\":\"topic:someTopic1\"}]",request2.getBody());
  Assert.assertEquals("[{\"message\":\"someValue2\",\"ddsource\":\"kafka-connect\",\"ddtags\":\"topic:someTopic2\"}]",request1.getBody());
}
