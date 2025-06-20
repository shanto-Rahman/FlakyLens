@Test public void writeLastIntegerInSegment() throws Exception {
assertEquals(asList(Segment.SIZE,4),data.segmentSizes());
assertEquals(repeat('a',Segment.SIZE - 4),data.readUtf8(Segment.SIZE - 4));
assertEquals("OkBuffer[size=8 data=abcdef0187654321]",data.toString());
}