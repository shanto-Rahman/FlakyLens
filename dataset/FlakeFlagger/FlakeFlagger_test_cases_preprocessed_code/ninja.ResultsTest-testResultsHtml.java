@Test public void testResultsHtml(){
assertEquals(Result.SC_200_OK,result.getStatusCode());
assertEquals(Result.TEXT_HTML,result.getContentType());
}