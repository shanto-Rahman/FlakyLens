@Test public void emptyResponseHeaderNameFromCacheIsLenient() throws Exception {
assertEquals("A",connection.getHeaderField(""));
}