@Test public void testResultsContentType(){
assertEquals(Result.SC_200_OK,result.getStatusCode());
assertEquals("text/my-cool-content-type",result.getContentType());
}