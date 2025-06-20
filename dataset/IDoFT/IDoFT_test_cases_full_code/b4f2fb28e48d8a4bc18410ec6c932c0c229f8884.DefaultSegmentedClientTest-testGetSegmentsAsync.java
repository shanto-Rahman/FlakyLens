@Test public void testGetSegmentsAsync() throws Exception {
  MockFace face=new MockFace();
  Name name=new Name("/test/segmented/client");
  Interest interest=new Interest(name);
  DataStream stream=instance.getSegmentsAsync(face,interest);
  TestCounter counter=new TestCounter();
  stream.observe((i,d) -> counter.count++);
  for (  Data segment : TestHelper.buildSegments(name,0,5)) {
    stream.onData(interest,segment);
  }
  assertEquals(5,counter.count);
  assertEquals("01234",stream.assemble().getContent().toString());
}
