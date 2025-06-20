@Test public void completeSegmentsEmitted() throws Exception {
assertEquals(Segment.SIZE * 3,sink.size());
}