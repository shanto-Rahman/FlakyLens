@Test public void writer_readingMultipleTopics_shouldBatchSeparate() throws IOException {
Assert.assertEquals(2,restHelper.getCapturedRequests().size());
Assert.assertEquals("[{\"message\":\"someValue1\",\"ddsource\":\"kafka-connect\",\"ddtags\":\"topic:someTopic1\"}]",request2.getBody());
Assert.assertEquals("[{\"message\":\"someValue2\",\"ddsource\":\"kafka-connect\",\"ddtags\":\"topic:someTopic2\"}]",request1.getBody());
}