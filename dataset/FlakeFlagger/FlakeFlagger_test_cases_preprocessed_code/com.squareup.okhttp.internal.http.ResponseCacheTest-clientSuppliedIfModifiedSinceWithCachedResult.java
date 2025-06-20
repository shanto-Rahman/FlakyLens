@Test public void clientSuppliedIfModifiedSinceWithCachedResult() throws Exception {
assertTrue(headers.contains("If-Modified-Since: " + ifModifiedSinceDate));
assertFalse(headers.contains("If-None-Match: v3"));
}