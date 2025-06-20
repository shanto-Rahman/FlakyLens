@Test public void testThatStaticAssetsDoNotSetNinjaCookies(){
assertEquals(null,httpResponse.getFirstHeader("Set-Cookie"));
}