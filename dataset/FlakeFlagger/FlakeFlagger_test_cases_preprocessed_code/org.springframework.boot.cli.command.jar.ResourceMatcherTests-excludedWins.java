@Test public void excludedWins() throws Exception {
List<MatchedResource> found=resourceMatcher.find(Arrays.asList(new File("src/test/resources")));//RO
assertThat(found,not(hasItem(new FooJarMatcher(MatchedResource.class))));
}