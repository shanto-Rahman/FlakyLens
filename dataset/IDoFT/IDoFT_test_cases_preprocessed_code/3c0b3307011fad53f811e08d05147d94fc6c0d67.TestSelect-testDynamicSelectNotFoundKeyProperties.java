/** 
 * 继承类可以使用,但多出来的属性无效
 */
@Test public void testDynamicSelectNotFoundKeyProperties(){
Assert.assertEquals(183,mapper.select(new Key()).size());
key.setCountrytel("+86");//IT
Assert.assertEquals(1,mapper.select(key).size());
}