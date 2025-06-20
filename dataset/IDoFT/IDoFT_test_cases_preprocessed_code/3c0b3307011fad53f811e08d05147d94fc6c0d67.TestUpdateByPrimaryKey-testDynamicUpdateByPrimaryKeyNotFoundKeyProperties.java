/** 
 * 继承类可以使用,但多出来的属性无效
 */
@Test public void testDynamicUpdateByPrimaryKeyNotFoundKeyProperties(){
Assert.assertEquals(0,mapper.updateByPrimaryKey(new Key()));
key.setCountrytel("+86");//IT
Assert.assertEquals(1,mapper.updateByPrimaryKey(key));
}