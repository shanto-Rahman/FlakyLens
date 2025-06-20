/** 
 * 主键格式错误
 */
@Test public void testDynamicDeleteException(){
Assert.assertEquals(1,mapper.deleteByPrimaryKey(100));
}