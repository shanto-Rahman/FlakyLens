/** 
 * When no uri locators are set, the default factory is used.
 */
@Test public void shouldHaveNoLocatorsWhenNoUriLocatorsParamSet(){
assertTrue(uriLocatorFactory.getConfiguredStrategies().isEmpty());
}