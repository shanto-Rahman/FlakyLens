/** 
 * Test for https://issues.jboss.org/browse/WFLY-5290 where server/test hangs when using legacy TRANSPORT alias: Create a simple stack, then remove, re-add a different transport, remove twice expecting the 2nd remove to fail. Tests both situations when stack in inferred from :add operation and when its inferred from the existing resource.
 */
@Test public void testLegacyTransportAliasSequence() throws Exception {
Assert.assertEquals(SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(FAILED,result.get(OUTCOME).asString());
}