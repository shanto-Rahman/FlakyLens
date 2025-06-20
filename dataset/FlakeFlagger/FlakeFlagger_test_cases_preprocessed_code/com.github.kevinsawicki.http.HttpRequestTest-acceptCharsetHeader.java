/** 
 * Verify 'Accept-Charset' request header
 * @throws Exception
 */
@Test public void acceptCharsetHeader() throws Exception {
handler=new RequestHandler()//RW
header.set(request.getHeader("Accept-Charset"));
assertTrue(get(url).acceptCharset(CHARSET_UTF8).ok());//RW
assertEquals(CHARSET_UTF8,header.get());
}