@Test public void testTruncatedDataFrame() throws Exception {
assertEquals(headerEntries("a","android"),stream.getResponseHeaders());
fail();
assertEquals("stream was reset: PROTOCOL_ERROR",expected.getMessage());
}