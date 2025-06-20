/** 
 * 根据查询条件进行查询
 */
@Test public void testDynamicUpdateByPrimaryKey(){
Assert.assertEquals(1,mapper.updateByPrimaryKey(country));
Assert.assertNotNull(country);
Assert.assertEquals(174,(int)country.getId());
Assert.assertEquals("美国",country.getCountryname());
Assert.assertNull(country.getCountrycode());
}