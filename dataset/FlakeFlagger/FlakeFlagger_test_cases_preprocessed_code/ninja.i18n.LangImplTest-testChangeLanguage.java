@Test public void testChangeLanguage(){
assertEquals("to",result.getCookie(cookie.getName()).getValue());
assertEquals(Result.SC_204_NO_CONTENT,result.getStatusCode());
}