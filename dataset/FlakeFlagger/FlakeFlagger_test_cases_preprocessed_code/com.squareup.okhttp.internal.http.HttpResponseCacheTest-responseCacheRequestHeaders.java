@Test public void responseCacheRequestHeaders() throws IOException, URISyntaxException {
assertEquals(Arrays.asList("android"),requestRef.get().headers("A"));
}