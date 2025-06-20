/** 
 * 查询全部
 */
@Test public void testDynamicSelectCount(){
Assert.assertEquals(183,mapper.selectCount(new Country()));
}