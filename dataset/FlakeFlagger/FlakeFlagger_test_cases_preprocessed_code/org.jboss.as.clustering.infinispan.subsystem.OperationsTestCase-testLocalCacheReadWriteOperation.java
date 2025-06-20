@Test public void testLocalCacheReadWriteOperation() throws Exception {
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertTrue(result.get(RESULT).asBoolean());
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertFalse(result.get(RESULT).asBoolean());
}