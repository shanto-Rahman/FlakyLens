/** 
 * 根据查询条件进行查询
 */
@Test public void testDynamicUpdateByPrimaryKeySelective(){
Assert.assertEquals(1,mapper.updateByPrimaryKeySelective(country));
Assert.assertNotNull(country);
Assert.assertEquals(173,(int)country.getId());
Assert.assertEquals("英国",country.getCountryname());
Assert.assertNotNull(country.getCountrycode());
Assert.assertEquals("GB",country.getCountrycode());
}