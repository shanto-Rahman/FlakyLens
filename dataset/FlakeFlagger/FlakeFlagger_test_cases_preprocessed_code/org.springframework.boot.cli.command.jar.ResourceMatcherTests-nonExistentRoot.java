@Test public void nonExistentRoot() throws IOException {
List<MatchedResource> matchedResources=resourceMatcher.find(Arrays.asList(new File("does-not-exist")));//RO
assertEquals(0,matchedResources.size());
}