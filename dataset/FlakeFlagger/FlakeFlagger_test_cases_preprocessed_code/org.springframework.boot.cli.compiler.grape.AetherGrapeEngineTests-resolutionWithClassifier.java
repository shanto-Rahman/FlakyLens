@Test public void resolutionWithClassifier(){
assertEquals(1,urls.length);
assertTrue(urls[0].toExternalForm().endsWith("-sources.jar"));
}