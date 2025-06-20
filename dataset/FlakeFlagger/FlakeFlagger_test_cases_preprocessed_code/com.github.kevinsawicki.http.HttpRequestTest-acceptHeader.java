/** 
 * Verify 'Accept' request header
 * @throws Exception
 */
@Test public void acceptHeader() throws Exception {
handler=new RequestHandler()//RW
header.set(request.getHeader("Accept"));
assertTrue(get(url).accept("application/json").ok());//RW
assertEquals("application/json",header.get());
}