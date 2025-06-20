/** 
 * 根据查询条件进行查询
 */
@Test public void testDynamicSelect(){
Assert.assertEquals(1,mapper.selectCount(country));
}