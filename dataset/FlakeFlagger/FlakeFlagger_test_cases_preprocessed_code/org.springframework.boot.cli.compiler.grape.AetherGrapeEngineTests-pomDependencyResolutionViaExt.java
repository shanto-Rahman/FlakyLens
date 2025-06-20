@Test public void pomDependencyResolutionViaExt(){
assertEquals(1,urls.length);
assertTrue(urls[0].toExternalForm().endsWith(".pom"));
}