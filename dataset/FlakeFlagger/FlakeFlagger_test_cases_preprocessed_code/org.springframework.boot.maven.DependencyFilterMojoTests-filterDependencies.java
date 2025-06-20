@Test public void filterDependencies() throws MojoExecutionException {
assertEquals("wrong filtering of artifacts",1,artifacts.size());
assertSame("Wrong filtered artifact",artifact,artifacts.iterator().next());
}