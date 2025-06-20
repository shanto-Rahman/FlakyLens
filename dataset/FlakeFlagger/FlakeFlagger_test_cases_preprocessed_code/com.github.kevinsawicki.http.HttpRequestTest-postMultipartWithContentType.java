/** 
 * Verify multipart with content type part header
 * @throws Exception
 */
@Test public void postMultipartWithContentType() throws Exception {
handler=new RequestHandler()//RW
body.set(new String(read()));
HttpRequest request=post(url);//RW
assertTrue(request.ok());
assertTrue(body.toString().contains("Content-Type: application/json"));
assertTrue(body.toString().contains("contents\r\n"));
}