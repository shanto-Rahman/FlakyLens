@Test public void incompleteSegmentsNotEmitted() throws Exception {
assertEquals(Segment.SIZE * 2,sink.size());
}