@Test public void emptyCommandLinePropertySourceNotAdded() throws Exception {
assertEquals("bucket",environment.getProperty("foo"));
}