/** 
 * Test failed POST request. 
 */
@Test @Category(NeedsRunner.class) public void failedSplunkWriteSingleBatchTest(){
  mockServerListening(404);
  int testPort=mockServer.getPort();
  List<KV<Integer,SplunkEvent>> testEvents=ImmutableList.of(KV.of(123,SplunkEvent.newBuilder().withEvent("test-event-1").withHost("test-host-1").withIndex("test-index-1").withSource("test-source-1").withSourceType("test-source-type-1").withTime(12345L).build()));
  PCollection<SplunkWriteError> actual=pipeline.apply("Create Input data",Create.of(testEvents).withCoder(KvCoder.of(BigEndianIntegerCoder.of(),SplunkEventCoder.of()))).apply("SplunkEventWriter",ParDo.of(SplunkEventWriter.newBuilder().withUrl(Joiner.on(':').join("http://localhost",testPort)).withInputBatchCount(StaticValueProvider.of(testEvents.size())).withToken("test-token").build())).setCoder(SplunkWriteErrorCoder.of());
  PAssert.that(actual).containsInAnyOrder(SplunkWriteError.newBuilder().withStatusCode(404).withStatusMessage("Not Found").withPayload("{\"time\":12345,\"host\":\"test-host-1\"," + "\"source\":\"test-source-1\",\"sourcetype\":\"test-source-type-1\"," + "\"index\":\"test-index-1\",\"event\":\"test-event-1\"}").build());
  pipeline.run();
  mockServer.verify(HttpRequest.request(EXPECTED_PATH),VerificationTimes.once());
}
