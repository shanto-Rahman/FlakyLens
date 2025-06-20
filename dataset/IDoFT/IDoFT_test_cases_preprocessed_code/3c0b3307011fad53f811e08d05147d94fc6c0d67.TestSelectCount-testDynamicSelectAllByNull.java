/** 
 * 入参为null时查询全部
 */
@Test public void testDynamicSelectAllByNull(){
Assert.assertEquals(183,mapper.selectCount(null));
}