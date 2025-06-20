/** 
 * Make a POST request with a non-empty request body
 * @throws Exception
 */
@Test public void postNonEmptyByteArray() throws Exception {
handler=new RequestHandler()//RW
body.set(new String(read()));
int code=post(url).contentLength(Integer.toString(bytes.length)).send(bytes).code();//RW
assertEquals(HTTP_OK,code);
assertEquals("hello",body.get());
}