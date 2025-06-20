/** 
 * Verify data is send when receiving response headers without first calling   {@link HttpRequest#code()}
 * @throws Exception
 */
@Test public void sendHeadersWithoutCode() throws Exception {
handler=new RequestHandler()//RW
body.set(new String(read()));
HttpRequest request=post(url).ignoreCloseExceptions(false);//RW
assertEquals("v1",headers.get("h1").get(0));
assertEquals("v2",headers.get("h2").get(0));
assertEquals("hello",body.get());
}