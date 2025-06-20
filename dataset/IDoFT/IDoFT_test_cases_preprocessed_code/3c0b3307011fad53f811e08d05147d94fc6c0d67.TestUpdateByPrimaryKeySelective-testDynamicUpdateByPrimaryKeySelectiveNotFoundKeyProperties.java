/** 
 * 继承类可以使用,但多出来的属性无效
 */
@Test public void testDynamicUpdateByPrimaryKeySelectiveNotFoundKeyProperties(){
key.setCountrytel("+86");//IT
Assert.assertEquals(1,mapper.updateByPrimaryKeySelective(key));
}