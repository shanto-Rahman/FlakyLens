@Test public void testRenderMultipleObjects(){
assertEquals(testObject,result.getRenderable());
assertTrue(result.getRenderable() instanceof Map);
assertEquals(string,resultMap.get("string"));
assertEquals(testObject,resultMap.get("testObject"));
assertTrue(gotException);
assertEquals(3,resultMap.size());
assertEquals(anotherObject,resultMap.get("anotherObject"));
assertEquals(2,resultMap.size());
assertEquals(anotherString,resultMap.get("anotherString"));
assertEquals(anotherTestObject,resultMap.get("anotherTestObject"));
}