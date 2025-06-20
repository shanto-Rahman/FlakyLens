/** 
 * Countrycode默认值HH
 */
@Test public void testDynamicInsertSelectiveNull(){
Assert.assertEquals(1,mapper.insertSelective(country));
Assert.assertEquals(1,list.size());
Assert.assertNotNull(list.get(0).getCountrycode());
Assert.assertEquals("HH",list.get(0).getCountrycode());
Assert.assertEquals(1,mapper.deleteByPrimaryKey(10086));
}