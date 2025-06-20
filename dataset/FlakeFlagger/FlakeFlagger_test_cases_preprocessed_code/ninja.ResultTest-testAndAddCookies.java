@Test public void testAndAddCookies(){
assertEquals(2,result.getCookies().size());
assertEquals("value1",result.getCookies().get(0).getValue());
assertEquals("value2",result.getCookies().get(1).getValue());
}