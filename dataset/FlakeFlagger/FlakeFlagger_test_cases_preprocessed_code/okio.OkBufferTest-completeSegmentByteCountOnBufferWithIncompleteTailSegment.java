@Test public void completeSegmentByteCountOnBufferWithIncompleteTailSegment() throws Exception {
assertEquals(Segment.SIZE * 3,buffer.completeSegmentByteCount());
}