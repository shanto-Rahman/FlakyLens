@Test public void testResultsXml(){
assertEquals(Result.SC_200_OK,result.getStatusCode());
assertEquals(Result.APPLICATION_XML,result.getContentType());
}