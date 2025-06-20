@Test public void shouldUseDefaultLocatorWhenNoneIsConfigured(){
assertEquals(ServletContextUriLocator.class,locator.getClass());
}