/** 
 * Verify 'Content-Type' header
 * @throws Exception
 */
@Test public void requestContentTypeEmptyCharset() throws Exception {
handler=new RequestHandler()//RW
contentType.set(request.getContentType());
assertTrue(post(url).contentType("text/html","").ok());//RW
assertEquals("text/html",contentType.get());
}