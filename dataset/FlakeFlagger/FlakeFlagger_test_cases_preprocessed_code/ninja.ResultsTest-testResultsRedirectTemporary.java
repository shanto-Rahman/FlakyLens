@Test public void testResultsRedirectTemporary(){
assertEquals(Result.SC_307_TEMPORARY_REDIRECT,result.getStatusCode());
assertEquals("http://example.com",result.getHeaders().get(Result.LOCATION));
assertTrue(result.getRenderable() instanceof NoHttpBody);
}