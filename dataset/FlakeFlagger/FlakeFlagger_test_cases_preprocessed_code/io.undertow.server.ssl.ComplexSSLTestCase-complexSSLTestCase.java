@Test public void complexSSLTestCase() throws IOException, GeneralSecurityException, URISyntaxException {
File rootPath=new File(FileHandlerTestCase.class.getResource("page.html").toURI()).getParentFile();//RO
Assert.assertEquals(200,resultList.getStatusLine().getStatusCode());
Assert.assertTrue(responseList,responseList.contains("page.html"));
Assert.assertEquals("text/html",headersList[0].getValue());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("text/html",headers[0].getValue());
Assert.assertTrue(response,response.contains("A web page"));
}