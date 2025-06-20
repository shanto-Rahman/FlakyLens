@Test public void getCookieTest(){
assertNull(doesNotExist);
assertEquals(cookie1.getName(),"contextCookie1");
assertEquals(cookie1.getValue(),"theValue1");
assertEquals(cookie2.getName(),"contextCookie2");
assertEquals(cookie2.getValue(),"theValue2");
}