@Test public void shouldDetectConfiguredLocators(){
assertEquals(5,locators.size());
assertEquals(ServletContextUriLocator.class,iterator.next().getClass());
assertEquals(ServletContextUriLocator.class,iterator.next().getClass());
assertEquals(ServletContextUriLocator.class,iterator.next().getClass());
assertEquals(ClasspathUriLocator.class,iterator.next().getClass());
assertEquals(UrlUriLocator.class,iterator.next().getClass());
}