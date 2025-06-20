@Test public void testCompositeKeys(){
Assert.assertNotNull(entityTable);
Assert.assertEquals(2,columns.size());
Assert.assertEquals(2,entityTable.getEntityClassPKColumns().size());
Assert.assertTrue(column.isId());
Assert.assertEquals(2,resultMap.getResultMappings().size());
Assert.assertTrue(resultMap.getResultMappings().get(0).getFlags().contains(ResultFlag.ID));
Assert.assertTrue(resultMap.getResultMappings().get(1).getFlags().contains(ResultFlag.ID));
Assert.assertEquals("<where> AND name = #{name} AND orgId = #{orgId}</where>",SqlHelper.wherePKColumns(UserCompositeKeys.class));
}