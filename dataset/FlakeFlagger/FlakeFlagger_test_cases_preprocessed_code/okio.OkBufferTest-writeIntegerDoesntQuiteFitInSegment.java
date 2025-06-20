@Test public void writeIntegerDoesntQuiteFitInSegment() throws Exception {
assertEquals(asList(Segment.SIZE - 3,8),data.segmentSizes());
assertEquals(repeat('a',Segment.SIZE - 3),data.readUtf8(Segment.SIZE - 3));
assertEquals("OkBuffer[size=8 data=abcdef0187654321]",data.toString());
}