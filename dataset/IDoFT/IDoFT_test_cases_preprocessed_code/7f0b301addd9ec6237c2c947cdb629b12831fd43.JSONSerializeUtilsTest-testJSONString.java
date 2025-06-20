@Test public void testJSONString(){
assertEquals(carJSON,newJSONString);
assertEquals(carJSON,newJSONString2.toString());
assertEquals(address,desAddress);
assertEquals(emptyStr,desEmptyStr);
assertNull(nullJson);
}