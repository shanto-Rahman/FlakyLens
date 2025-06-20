/** 
 * 对象包含主键即可
 */
@Test public void testDynamicDeleteEntity(){
Assert.assertEquals(1,mapper.deleteByPrimaryKey(country));
}