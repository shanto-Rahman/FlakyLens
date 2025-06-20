@Test public void shouldUseServletContextOnlyLocator(){
assertEquals(1,locators.size());
assertEquals(ServletContextUriLocator.class,locators.iterator().next().getClass());
}