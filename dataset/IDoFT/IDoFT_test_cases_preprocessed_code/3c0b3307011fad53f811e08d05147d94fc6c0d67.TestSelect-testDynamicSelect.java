/** 
 * 根据查询条件进行查询
 */
@Test public void testDynamicSelect(){
Assert.assertEquals(1,countryList.size());
Assert.assertEquals(true,countryList.get(0).getId() == 35);
Assert.assertEquals("China",countryList.get(0).getCountryname());
}