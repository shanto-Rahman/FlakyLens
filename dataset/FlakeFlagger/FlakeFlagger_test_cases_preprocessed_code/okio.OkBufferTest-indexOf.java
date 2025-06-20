@Test public void indexOf() throws Exception {
assertEquals(-1,buffer.indexOf((byte)'a'));
assertEquals(0,buffer.indexOf((byte)'a'));
assertEquals(-1,buffer.indexOf((byte)'b'));
assertEquals(0,buffer.indexOf((byte)'a'));
assertEquals(1,buffer.indexOf((byte)'b'));
assertEquals(-1,buffer.indexOf((byte)'c'));
assertEquals(-1,buffer.indexOf((byte)'a'));
assertEquals(0,buffer.indexOf((byte)'b'));
assertEquals(-1,buffer.indexOf((byte)'c'));
assertEquals(-1,buffer.indexOf((byte)'a'));
assertEquals(0,buffer.indexOf((byte)'b'));
assertEquals(Segment.SIZE - 3,buffer.indexOf((byte)'c'));
assertEquals(-1,buffer.indexOf((byte)'a'));
assertEquals(0,buffer.indexOf((byte)'b'));
assertEquals(Segment.SIZE - 5,buffer.indexOf((byte)'c'));
assertEquals(asList(Segment.SIZE - 4,1),buffer.segmentSizes());
assertEquals(Segment.SIZE - 4,buffer.indexOf((byte)'d'));
assertEquals(-1,buffer.indexOf((byte)'e'));
}