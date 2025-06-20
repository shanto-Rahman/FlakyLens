/** 
 * Checks that modelFactories provided as a list will have all required fields injected (ex: locatorFactory)
 */
@Test public void shouldInjectInnerModelFactories(){
Assert.assertNotNull("Should have an injected locator!",uriLocatorFactory);
Assert.assertNotNull(factory.create());
}