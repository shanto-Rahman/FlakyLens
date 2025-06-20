@Test public void etag() throws Exception {
assertTrue(conditionalRequest.getHeaders().contains("If-None-Match: v1"));
}