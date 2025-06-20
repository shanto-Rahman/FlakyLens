@Test public void cloneMultipleSegments() throws Exception {
assertEquals(repeat('a',Segment.SIZE * 3) + repeat('b',Segment.SIZE * 3),original.readUtf8(Segment.SIZE * 6));
assertEquals(repeat('a',Segment.SIZE * 3) + repeat('c',Segment.SIZE * 3),clone.readUtf8(Segment.SIZE * 6));
}