@Test public void testResultsJson(){
assertEquals(Result.SC_200_OK,result.getStatusCode());
assertEquals(Result.APPLICATON_JSON,result.getContentType());
}