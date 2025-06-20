@Test public void completeSegmentByteCountOnBufferWithFullSegments() throws Exception {
assertEquals(Segment.SIZE * 4,buffer.completeSegmentByteCount());
}