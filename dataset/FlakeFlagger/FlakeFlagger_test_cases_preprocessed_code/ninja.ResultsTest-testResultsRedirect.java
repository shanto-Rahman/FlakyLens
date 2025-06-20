@Test public void testResultsRedirect(){
assertEquals(Result.SC_303_SEE_OTHER,result.getStatusCode());
assertEquals("http://example.com",result.getHeaders().get(Result.LOCATION));
assertTrue(result.getRenderable() instanceof NoHttpBody);
}