/** 
 * Map可以随意
 */
@Test public void testDynamicDeleteMap(){
Assert.assertEquals(1,mapper.deleteByPrimaryKey(map));
Assert.assertEquals(0,mapper.deleteByPrimaryKey(map));
}