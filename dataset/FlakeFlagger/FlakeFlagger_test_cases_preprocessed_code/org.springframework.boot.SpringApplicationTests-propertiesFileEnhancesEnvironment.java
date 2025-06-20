@Test public void propertiesFileEnhancesEnvironment() throws Exception {
assertEquals("bucket",environment.getProperty("foo"));
}