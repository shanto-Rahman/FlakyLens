@Test public void test(){
Assert.assertEquals("SELECT id,user_name,address,state  FROM user " + "<where>" + "<if test=\"id != null\"> AND id = #{id}</if>"+ "<if test=\"userName != null\"> AND user_name = #{userName}</if>"+ "<if test=\"address != null\"> AND address = #{address, typeHandler=tk.mybatis.mapper.mapperhelper.ComplexEntityTest.AddressHandler}</if>"+ "<if test=\"state != null\"> AND state = #{state}</if></where>",sql);
Assert.assertEquals("id",idMapping.getColumn());
Assert.assertEquals("id",idMapping.getProperty());
Assert.assertTrue(idMapping.getFlags().contains(ResultFlag.ID));
Assert.assertEquals("user_name",userNameMapping.getColumn());
Assert.assertEquals("userName",userNameMapping.getProperty());
Assert.assertEquals("address",addressMapping.getColumn());
Assert.assertEquals("address",addressMapping.getProperty());
Assert.assertEquals(AddressHandler.class,addressMapping.getTypeHandler().getClass());
Assert.assertEquals("state",stateMapping.getColumn());
Assert.assertEquals("state",stateMapping.getProperty());
Assert.assertEquals(EnumTypeHandler.class,stateMapping.getTypeHandler().getClass());
}