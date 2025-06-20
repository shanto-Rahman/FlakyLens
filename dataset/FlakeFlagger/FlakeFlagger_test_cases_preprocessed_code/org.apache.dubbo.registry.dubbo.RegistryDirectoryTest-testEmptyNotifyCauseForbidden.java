/** 
 * Empty notify cause forbidden, non-empty notify cancels forbidden state
 */
@Test public void testEmptyNotifyCauseForbidden(){
Assert.assertEquals(RpcException.FORBIDDEN_EXCEPTION,e.getCode());
Assert.assertEquals(false,registryDirectory.isAvailable());
Assert.assertEquals(true,registryDirectory.isAvailable());
Assert.assertEquals(2,invokers.size());
}