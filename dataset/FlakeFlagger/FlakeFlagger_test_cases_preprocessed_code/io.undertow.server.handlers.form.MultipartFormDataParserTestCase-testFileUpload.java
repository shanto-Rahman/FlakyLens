@Test public void testFileUpload() throws Exception {
entity.addPart("file",new FileBody(new File(MultipartFormDataParserTestCase.class.getResource("uploadfile.txt").getFile())));//RO
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
}