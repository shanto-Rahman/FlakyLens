/** 
 * Test whether the override rule have a high priority Scene: the rules of the push are the same as the parameters of the provider Expectation: no need to be re-referenced
 */
@Test public void testNotifyoverrideUrls_Nouse(){
Assert.assertEquals(2,invokers.size());
Assert.assertEquals(true,registryDirectory.isAvailable());
Assert.assertEquals(2,invokers.size());
Assert.assertFalse("object not same",a1Invoker == a2Invoker);
Assert.assertTrue("object same",b1Invoker == b2Invoker);
}