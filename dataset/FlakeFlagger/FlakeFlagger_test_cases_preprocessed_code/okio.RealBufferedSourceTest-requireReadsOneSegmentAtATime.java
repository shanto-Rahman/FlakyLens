@Test public void requireReadsOneSegmentAtATime() throws Exception {
assertEquals(Segment.SIZE,source.size());
assertEquals(Segment.SIZE,bufferedSource.buffer().size());
}