@Test public void sourceFromInputStream() throws Exception {
assertEquals(3,source.read(sink,3));
assertEquals("abb",sink.readUtf8(3));
assertEquals(Segment.SIZE,source.read(sink,20000));
assertEquals(repeat('b',Segment.SIZE),sink.readUtf8(sink.size()));
assertEquals(Segment.SIZE - 1,source.read(sink,20000));
assertEquals(repeat('b',Segment.SIZE - 2) + "c",sink.readUtf8(sink.size()));
assertEquals(-1,source.read(sink,1));
}