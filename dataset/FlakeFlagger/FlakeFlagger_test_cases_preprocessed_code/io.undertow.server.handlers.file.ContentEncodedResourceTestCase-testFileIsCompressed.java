@Test public void testFileIsCompressed() throws IOException, InterruptedException {
File f=new File(tmpDir,fileName);//RW
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("hello world",response);
Assert.assertEquals("deflate",result.getHeaders(Headers.CONTENT_ENCODING_STRING)[0].getValue());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("hello world",response);
Assert.assertEquals("deflate",result.getHeaders(Headers.CONTENT_ENCODING_STRING)[0].getValue());
}