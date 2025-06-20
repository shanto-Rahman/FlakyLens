/** 
 * Verify data is sent when receiving response without first calling   {@link HttpRequest#code()}
 * @throws Exception
 */
@Test public void sendReceiveWithoutCode() throws Exception {
handler=new RequestHandler()//RW
body.set(new String(read()));
HttpRequest request=post(url).ignoreCloseExceptions(false);//RW
assertEquals("world",request.send("hello").body());
assertEquals("hello",body.get());
}