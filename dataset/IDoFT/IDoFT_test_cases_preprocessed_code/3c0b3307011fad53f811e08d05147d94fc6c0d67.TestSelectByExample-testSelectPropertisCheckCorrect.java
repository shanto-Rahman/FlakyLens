/** 
 * 指定查询字段正确
 */
@Test public void testSelectPropertisCheckCorrect(){
Assert.assertEquals(null,country1.get(0).getId());
Assert.assertEquals("China",country1.get(0).getCountryname());
Assert.assertEquals(null,country1.get(0).getCountrycode());
}