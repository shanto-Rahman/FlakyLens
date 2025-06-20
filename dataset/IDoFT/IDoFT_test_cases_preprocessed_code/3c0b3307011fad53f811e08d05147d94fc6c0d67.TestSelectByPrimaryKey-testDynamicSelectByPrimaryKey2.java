/** 
 * 根据PK进行查询
 */
@Test public void testDynamicSelectByPrimaryKey2(){
Assert.assertNotNull(country);
Assert.assertEquals(true,country.getId() == 35);
Assert.assertEquals("China",country.getCountryname());
Assert.assertEquals("CN",country.getCountrycode());
}