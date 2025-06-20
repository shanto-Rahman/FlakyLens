/** 
 * 根据查询条件进行查询
 */
@Test public void testDynamicSelect(){
Assert.assertEquals(true,result.getId() == 35);
Assert.assertEquals("China",result.getCountryname());
}