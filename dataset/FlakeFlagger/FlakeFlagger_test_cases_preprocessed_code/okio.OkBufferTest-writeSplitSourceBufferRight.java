/** 
 * The big part of source's first segment is staying put. 
 */
@Test public void writeSplitSourceBufferRight() throws Exception {
assertEquals(asList(Segment.SIZE - 10,writeSize),sink.segmentSizes());
assertEquals(asList(Segment.SIZE - writeSize,Segment.SIZE),source.segmentSizes());
}