@Test public void writePrefixDoesntSplitButRequiresCompact() throws Exception {
assertEquals(asList(30),sink.segmentSizes());
assertEquals(asList(Segment.SIZE - 20,Segment.SIZE),source.segmentSizes());
assertEquals(30,sink.size());
assertEquals(Segment.SIZE * 2 - 20,source.size());
}