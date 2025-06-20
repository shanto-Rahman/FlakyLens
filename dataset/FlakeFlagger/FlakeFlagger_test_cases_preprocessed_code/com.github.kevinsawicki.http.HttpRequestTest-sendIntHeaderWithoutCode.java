/** 
 * Verify data is send when receiving response integer header without first calling    {@link HttpRequest#code()}
 * @throws Exception
 */
@Test public void sendIntHeaderWithoutCode() throws Exception {
handler=new RequestHandler()//RW
body.set(new String(read()));
HttpRequest request=post(url).ignoreCloseExceptions(false);//RW
assertEquals(9876,request.send("hello").intHeader("Width"));
assertEquals("hello",body.get());
}