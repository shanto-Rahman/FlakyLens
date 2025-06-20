@Test public void shouldDetectConfiguredLocator(){
assertEquals(1,locators.size());
assertEquals(ServletContextUriLocator.class,locators.iterator().next().getClass());
}