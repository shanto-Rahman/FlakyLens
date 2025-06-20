/** 
 * Verify data is send when receiving response date header without first calling    {@link HttpRequest#code()}
 * @throws Exception
 */
@Test public void sendDateHeaderWithoutCode() throws Exception {
handler=new RequestHandler()//RW
body.set(new String(read()));
HttpRequest request=post(url).ignoreCloseExceptions(false);//RW
assertEquals(1000,request.send("hello").date());
assertEquals("hello",body.get());
}