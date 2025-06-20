/** 
 * Verify 'If-Modified-Since' request header
 * @throws Exception
 */
@Test public void ifModifiedSinceHeader() throws Exception {
handler=new RequestHandler()//RW
header.set(request.getDateHeader("If-Modified-Since"));
assertTrue(get(url).ifModifiedSince(5000).ok());//RW
assertEquals(5000,header.get());
}