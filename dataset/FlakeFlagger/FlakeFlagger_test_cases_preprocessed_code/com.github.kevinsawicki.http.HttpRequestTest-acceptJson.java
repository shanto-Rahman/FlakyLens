/** 
 * Verify 'Accept' request header when calling   {@link HttpRequest#acceptJson()}
 * @throws Exception
 */
@Test public void acceptJson() throws Exception {
handler=new RequestHandler()//RW
header.set(request.getHeader("Accept"));
assertTrue(get(url).acceptJson().ok());//RW
assertEquals("application/json",header.get());
}