@Test public void components_default(){
assertTrue(config.isAutoDiscoverComponents());
assertEquals("/WEB-INF/webx-*.xml",config.getComponentConfigurationLocationPattern());
assertNull(config.getDefaultComponent());
assertEquals(WebxControllerImpl.class,config.getDefaultControllerClass());
assertTrue(config.getComponents().isEmpty());
}