@Test public void commandLinePropertySourceEnhancesEnvironment() throws Exception {
assertTrue(hasPropertySource(environment,CompositePropertySource.class,"commandLineArgs"));
assertEquals("foo",environment.getProperty("bar"));
assertEquals("bar",environment.getProperty("foo"));
}