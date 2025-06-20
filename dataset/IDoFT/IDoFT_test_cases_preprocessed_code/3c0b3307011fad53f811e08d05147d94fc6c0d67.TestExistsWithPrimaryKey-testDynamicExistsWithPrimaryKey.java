/** 
 * 根据PK进行查询
 */
@Test public void testDynamicExistsWithPrimaryKey(){
Assert.assertEquals(true,mapper.existsWithPrimaryKey(country));
Assert.assertEquals(false,mapper.existsWithPrimaryKey(country));
}