/** 
 * Verify multipart with file, stream, number, and string parameters
 * @throws Exception
 */
@Test public void postMultipart() throws Exception {
handler=new RequestHandler()//RW
fail();
new FileWriter(file).append("content1").close();
new FileWriter(file2).append("content4").close();
HttpRequest request=post(url);//RW
assertTrue(request.ok());
assertTrue(body.toString().contains("content1\r\n"));
assertTrue(body.toString().contains("content2\r\n"));
assertTrue(body.toString().contains("content3\r\n"));
assertTrue(body.toString().contains("content4\r\n"));
assertTrue(body.toString().contains(Long.toString(file.length()) + "\r\n"));
}