@Test public void verifyThatSegmentsAreRetrievedOnlyOnce() throws Exception {
  MockForwarder forwarder=new MockForwarder();
  Face face=forwarder.connect();
  Name name=new Name("/test/segmented/client");
  Interest interest=new Interest(name);
  DataStream stream=instance.getSegmentsAsync(face,interest);
  TestCounter counter=new TestCounter();
  stream.observe((i,d) -> counter.count++);
  for (  Data segment : TestHelper.buildSegments(name,0,5)) {
    face.putData(segment);
    face.processEvents();
  }
  assertEquals(5,counter.count);
  assertEquals(5,((MeasurableFace)face).sentInterests().size());
  assertEquals("01234",stream.assemble().getContent().toString());
}
