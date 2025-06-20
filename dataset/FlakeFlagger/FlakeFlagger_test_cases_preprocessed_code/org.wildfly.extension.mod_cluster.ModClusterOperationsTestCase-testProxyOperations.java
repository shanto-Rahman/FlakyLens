@Test public void testProxyOperations() throws Exception {
Assert.assertEquals(result.get(FAILURE_DESCRIPTION).asString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertTrue(String.format("'%s' operation is not registered at the proxy address",operationName),result.get(RESULT).asList().contains(new ModelNode(operationName)));
}