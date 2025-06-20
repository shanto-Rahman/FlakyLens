/** 
 * Verify 'Content-Type' header
 * @throws Exception
 */
@Test public void requestContentType() throws Exception {
handler=new RequestHandler()//RW
contentType.set(request.getContentType());
assertTrue(post(url).contentType("text/html","UTF-8").ok());//RW
assertEquals("text/html; charset=UTF-8",contentType.get());
}