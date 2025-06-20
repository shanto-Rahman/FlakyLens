@Test public void testLegacyConnectorOperations() throws Exception {
Assert.assertEquals(result.get(FAILURE_DESCRIPTION).asString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(result.get(FAILURE_DESCRIPTION).asString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(testListenerName,result.get(RESULT).asString());
}