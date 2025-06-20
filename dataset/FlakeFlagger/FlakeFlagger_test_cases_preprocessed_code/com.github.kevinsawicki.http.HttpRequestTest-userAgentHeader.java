/** 
 * Verify 'User-Agent' request header
 * @throws Exception
 */
@Test public void userAgentHeader() throws Exception {
handler=new RequestHandler()//RW
header.set(request.getHeader("User-Agent"));
assertTrue(get(url).userAgent("browser 1.0").ok());//RW
assertEquals("browser 1.0",header.get());
}