/** 
 * Make a GET request that should be compressed but isn't
 * @throws Exception
 */
@Test public void getNonGzippedWithUncompressEnabled() throws Exception {
handler=new RequestHandler()//RW
if (!"gzip".equals(request.getHeader("Accept-Encoding"))) return;
HttpRequest request=get(url).acceptGzipEncoding().uncompress(true);//RW
assertTrue(request.ok());
assertEquals("hello not compressed",request.body(CHARSET_UTF8));
}