/** 
 * Tests that legacy proxy operations are registered at the subsystem level.
 */
@Test public void testLegacyProxyOperations() throws Exception {
Assert.assertEquals(result.get(FAILURE_DESCRIPTION).asString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertTrue(String.format("'%s' legacy operation is not registered",operationName),result.get(RESULT).asList().contains(new ModelNode(operationName)));
Assert.assertEquals(rodResult.get(FAILURE_DESCRIPTION).asString(),SUCCESS,rodResult.get(OUTCOME).asString());
Assert.assertTrue(rodResult.get(RESULT).hasDefined(DEPRECATED));
}