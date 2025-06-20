@Test public void testGetSegmentsAsync() throws Exception {
assertEquals(5,counter.count);
assertEquals("01234",stream.assemble().getContent().toString());
}