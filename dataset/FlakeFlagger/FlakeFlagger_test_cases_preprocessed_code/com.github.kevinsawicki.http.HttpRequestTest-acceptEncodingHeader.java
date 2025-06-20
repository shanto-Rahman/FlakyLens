/** 
 * Verify 'Accept-Encoding' request header
 * @throws Exception
 */
@Test public void acceptEncodingHeader() throws Exception {
handler=new RequestHandler()//RW
header.set(request.getHeader("Accept-Encoding"));
assertTrue(get(url).acceptEncoding("compress").ok());//RW
assertEquals("compress",header.get());
}