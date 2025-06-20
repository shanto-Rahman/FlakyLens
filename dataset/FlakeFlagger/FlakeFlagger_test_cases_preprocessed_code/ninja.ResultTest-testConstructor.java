@Test public void testConstructor(){
assertEquals(Result.SC_307_TEMPORARY_REDIRECT,result.getStatusCode());
assertEquals(0,result.getCookies().size());
assertEquals(0,result.getHeaders().keySet().size());
}