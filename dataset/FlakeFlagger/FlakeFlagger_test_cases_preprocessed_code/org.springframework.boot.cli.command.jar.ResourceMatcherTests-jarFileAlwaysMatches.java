@Test public void jarFileAlwaysMatches() throws Exception {
List<MatchedResource> found=resourceMatcher.find(Arrays.asList(new File("src/test/resources/templates"),new File("src/test/resources/foo.jar")));//RO
assertThat(found,hasItem(matcher));
assertTrue(matcher.getMatched().isRoot());
}