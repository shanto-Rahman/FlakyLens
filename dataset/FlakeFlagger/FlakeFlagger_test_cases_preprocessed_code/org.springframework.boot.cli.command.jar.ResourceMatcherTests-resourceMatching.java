@Test public void resourceMatching() throws IOException {
List<MatchedResource> matchedResources=resourceMatcher.find(Arrays.asList(new File("src/test/resources/resource-matcher/one"),new File("src/test/resources/resource-matcher/two"),new File("src/test/resources/resource-matcher/three")));//RO
assertEquals(6,paths.size());
assertTrue(paths.containsAll(Arrays.asList("alpha/nested/fileA","bravo/fileC","fileD","bravo/fileE","fileF","three")));
}