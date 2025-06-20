@Test public void hasCookieTest(){
assertFalse(context.hasCookie("doesNotExist"));
assertTrue(context.hasCookie("contextCookie1"));
assertTrue(context.hasCookie("contextCookie2"));
}