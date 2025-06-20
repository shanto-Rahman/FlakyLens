/** 
 * Test configuration
 * @throws Throwable Thrown if case of an error
 */
@Test public void testRegistryConfiguration() throws Throwable {
assertNotNull(controller);
assertNotNull(repository);
assertNotNull(ids);
if (id.indexOf("PureInflow") != -1) {
}
assertEquals(1,pureInflowListener);
assertNotNull(piId);
assertNotNull(endpoint);
assertNotNull(listeners);
assertEquals(1,listeners.size());
assertNotNull(as);
assertNotNull(as.getResourceAdapter());
}