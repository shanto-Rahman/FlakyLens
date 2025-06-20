/** 
 * 根据查询条件进行查询
 */
@Test public void testUpdateByPrimaryKeyAndVersion(){
Assert.assertNotNull(country);
Assert.assertEquals(new Integer(1),country.getVersion());
Assert.assertEquals(1,mapper.updateByPrimaryKey(country));
Assert.assertNotNull(country);
Assert.assertEquals(new Integer(2),country.getVersion());
Assert.assertEquals(1,mapper.updateByPrimaryKey(country));
Assert.assertNotNull(country);
Assert.assertEquals(new Integer(3),country.getVersion());
Assert.assertEquals(1,mapper.updateByPrimaryKey(country));
Assert.assertNotNull(country);
Assert.assertEquals(new Integer(4),country.getVersion());
}