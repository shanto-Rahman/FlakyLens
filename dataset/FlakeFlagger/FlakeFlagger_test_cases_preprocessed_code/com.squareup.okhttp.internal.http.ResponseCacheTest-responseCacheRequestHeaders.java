@Test public void responseCacheRequestHeaders() throws IOException, URISyntaxException {
requestHeadersRef.set(requestHeaders);
assertEquals(Arrays.asList("android"),requestHeadersRef.get().get("A"));
}