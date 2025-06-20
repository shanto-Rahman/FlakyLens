@Test public void testLocalCacheRemoveRemoveSequence() throws Exception {
Assert.assertEquals(result.get(FAILURE_DESCRIPTION).asString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(result.get(FAILURE_DESCRIPTION).asString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(result.toString(),FAILED,result.get(OUTCOME).asString());
}