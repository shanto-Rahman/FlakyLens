/** 
 * Test mock provider distribution
 */
@Test public void testNotify_MockProviderOnly(){
Assert.assertEquals(true,registryDirectory.isAvailable());
Assert.assertEquals(2,invokers.size());
Assert.assertEquals(1,invokers.size());
}