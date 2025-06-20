/** 
 * 包含主键的对象做参数就行
 */
@Test public void testDynamicSelectByPrimaryKey(){
Assert.assertNotNull(country);
Assert.assertEquals(true,country.getId() == 35);
Assert.assertEquals("China",country.getCountryname());
Assert.assertEquals("CN",country.getCountrycode());
}