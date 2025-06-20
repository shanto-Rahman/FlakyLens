@Test public void testFileBasedErrorPageIsGenerated() throws IOException {
final FileErrorPageHandler handler=new FileErrorPageHandler(new File(getClass().getResource("errorpage.html").getFile()),404);//RO
Assert.assertEquals(404,result.getStatusLine().getStatusCode());
Assert.assertTrue(response,response.contains("Custom Error Page"));
}