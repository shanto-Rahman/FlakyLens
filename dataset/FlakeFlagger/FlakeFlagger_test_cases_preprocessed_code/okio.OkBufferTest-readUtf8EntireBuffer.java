@Test public void readUtf8EntireBuffer() throws Exception {
assertEquals(repeat('a',Segment.SIZE),buffer.readUtf8(Segment.SIZE));
}