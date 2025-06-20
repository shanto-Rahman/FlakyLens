/** 
 * Verify setting headers
 * @throws Exception
 */
@Test public void headers() throws Exception {
handler=new RequestHandler()//RW
h1.set(request.getHeader("h1"));
h2.set(request.getHeader("h2"));
assertTrue(get(url).headers(headers).ok());//RW
assertEquals("v1",h1.get());
assertEquals("v2",h2.get());
}