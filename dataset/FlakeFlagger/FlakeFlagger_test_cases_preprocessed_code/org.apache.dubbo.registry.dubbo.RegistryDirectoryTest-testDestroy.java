/** 
 * When destroying, RegistryDirectory should: 1. be disconnected from Registry 2. destroy all invokers
 */
@Test public void testDestroy(){
Assert.assertEquals(true,registryDirectory.isAvailable());
Assert.assertEquals(true,invokers.get(0).isAvailable());
Assert.assertEquals(false,registryDirectory.isAvailable());
Assert.assertEquals(false,invokers.get(0).isAvailable());
Assert.assertTrue(methodInvokerMap == null);
Assert.assertEquals(0,urlInvokerMap.size());
fail();
Assert.assertTrue(e.getMessage().contains("already destroyed"));
}