/** 
 * Make a POST and send request using a writer
 * @throws Exception
 */
@Test public void sendWithWriter() throws Exception {
handler=new RequestHandler()//RW
body.set(new String(read()));
HttpRequest request=post(url);//RW
assertTrue(request.ok());
assertEquals("hello",body.get());
}