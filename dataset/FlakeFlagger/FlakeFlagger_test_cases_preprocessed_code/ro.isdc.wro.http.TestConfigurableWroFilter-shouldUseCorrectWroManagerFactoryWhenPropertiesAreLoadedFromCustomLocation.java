@Test public void shouldUseCorrectWroManagerFactoryWhenPropertiesAreLoadedFromCustomLocation() throws Exception {
assertEquals(NoProcessorsWroManagerFactory.class,actual.getClass());
}