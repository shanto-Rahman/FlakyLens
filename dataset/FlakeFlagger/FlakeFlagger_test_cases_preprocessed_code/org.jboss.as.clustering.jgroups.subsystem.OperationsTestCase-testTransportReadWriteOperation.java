/** 
 * Tests access to transport attributes
 */
@Test public void testTransportReadWriteOperation() throws Exception {
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals("rack1",ExpressionResolver.TEST_RESOLVER.resolveExpressions(result.get(RESULT)).asString());
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals("new-rack",result.get(RESULT).asString());
}