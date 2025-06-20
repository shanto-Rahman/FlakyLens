@Test public void testResultsJsonWithObjectToRender(){
assertEquals(Result.SC_200_OK,result.getStatusCode());
assertEquals(Result.APPLICATON_JSON,result.getContentType());
assertEquals(testObject,result.getRenderable());
}