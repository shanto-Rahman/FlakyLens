/** 
 * Test push only router
 */
@Test public void testNotified_Normal_withRouters(){
Assert.assertEquals(true,registryDirectory.isAvailable());
Assert.assertTrue("notify no invoker urls ,should not error",LogUtil.checkNoError());
}