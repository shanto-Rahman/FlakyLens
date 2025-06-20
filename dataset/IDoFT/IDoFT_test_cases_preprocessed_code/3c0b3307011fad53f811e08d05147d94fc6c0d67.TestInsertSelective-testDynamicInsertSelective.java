/** 
 * 插入完整数据
 */
@Test public void testDynamicInsertSelective(){
Assert.assertEquals(1,mapper.insertSelective(country));
Assert.assertEquals(2,list.size());
Assert.assertEquals(1,mapper.deleteByPrimaryKey(10086));
}