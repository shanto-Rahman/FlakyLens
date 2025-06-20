@Test public void skipReadsOneSegmentAtATime() throws Exception {
assertEquals(Segment.SIZE,source.size());
assertEquals(Segment.SIZE - 2,bufferedSource.buffer().size());
}