@Test public void testRedirectTemporary(){
assertEquals(1,result.getHeaders().size());
assertEquals("http://example.com",result.getHeaders().get(Result.LOCATION));
assertEquals(Result.SC_307_TEMPORARY_REDIRECT,result.getStatusCode());
}