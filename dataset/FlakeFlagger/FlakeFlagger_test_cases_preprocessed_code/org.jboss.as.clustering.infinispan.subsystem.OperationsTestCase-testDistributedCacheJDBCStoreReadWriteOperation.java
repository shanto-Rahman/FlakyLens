@SuppressWarnings("deprecation") @Test public void testDistributedCacheJDBCStoreReadWriteOperation() throws Exception {
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals("ExampleDS",result.get(RESULT).asString());
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals("new-datasource",result.get(RESULT).asString());
Assert.assertEquals(result.toString(),SUCCESS,result.get(OUTCOME).asString());
Assert.assertEquals(stringKeyedTable.asPropertyList().size(),result.get(RESULT).asPropertyList().size());
Assert.assertTrue(result.get(RESULT).hasDefined(property.getName()));
Assert.assertEquals(property.getValue(),result.get(RESULT).get(property.getName()));
}