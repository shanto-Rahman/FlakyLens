@Test public void moveBytesBetweenBuffersMultipleSegments() throws Exception {
assertEquals(asList(Segment.SIZE,Segment.SIZE,Segment.SIZE,1,Segment.SIZE,Segment.SIZE,Segment.SIZE,1),segmentSizes);
}