@Test public void testFileIsServed() throws IOException, URISyntaxException {
File rootPath=new File(getClass().getResource("page.html").toURI()).getParentFile();//RO
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("text/html",headers[0].getValue());
Assert.assertTrue(response,response.contains("A web page"));
}