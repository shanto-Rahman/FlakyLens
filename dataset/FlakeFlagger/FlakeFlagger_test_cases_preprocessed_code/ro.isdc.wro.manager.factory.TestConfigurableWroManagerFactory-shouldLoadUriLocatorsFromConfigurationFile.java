@Test public void shouldLoadUriLocatorsFromConfigurationFile(){
assertEquals(1,uriLocatorFactory.getConfiguredStrategies().size());
assertSame(ServletContextUriLocator.class,uriLocatorFactory.getConfiguredStrategies().iterator().next().getClass());
}