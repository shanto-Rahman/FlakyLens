@Test public void testLegacyMetricOperations() throws Exception {
Assert.assertEquals(result.get(FAILURE_DESCRIPTION).asString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(result.get(FAILURE_DESCRIPTION).asString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(result.get(FAILURE_DESCRIPTION).asString(),FAILED,result.get(OUTCOME).asString());
}