@Test public void clientSuppliedIfNoneMatchSinceWithCachedResult() throws Exception {
assertTrue(headers.contains("If-None-Match: v1"));
assertFalse(headers.contains("If-Modified-Since: " + lastModifiedDate));
}