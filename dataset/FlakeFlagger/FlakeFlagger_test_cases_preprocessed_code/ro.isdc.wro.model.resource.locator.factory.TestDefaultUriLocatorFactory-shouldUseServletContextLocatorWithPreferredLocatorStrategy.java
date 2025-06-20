@Test public void shouldUseServletContextLocatorWithPreferredLocatorStrategy(){
if (locator instanceof ServletContextUriLocator) {
assertEquals(LocatorStrategy.DISPATCHER_FIRST,((ServletContextUriLocator)locator).getLocatorStrategy());
}
}