/** 
 * Map可以随意
 */
@Test public void testSelectByPrimaryKeyMap(){
Assert.assertNotNull(country);
Assert.assertEquals(true,country.getId() == 35);
Assert.assertEquals("China",country.getCountryname());
Assert.assertEquals("CN",country.getCountrycode());
Assert.assertNull(mapper.selectByPrimaryKey(map));
}