@Test public void shouldLoadUriLocatorsFromFilterConfigRatherThanFromConfigProperties(){
assertEquals(2,uriLocatorFactory.getConfiguredStrategies().size());
assertSame(ClasspathUriLocator.class,locatorsIterator.next().getClass());
assertSame(ServletContextUriLocator.class,locatorsIterator.next().getClass());
}