@Test public void testResultsHtmlWithStatusCode(){
assertEquals(Result.SC_300_MULTIPLE_CHOICES,result.getStatusCode());
assertEquals(Result.TEXT_HTML,result.getContentType());
}