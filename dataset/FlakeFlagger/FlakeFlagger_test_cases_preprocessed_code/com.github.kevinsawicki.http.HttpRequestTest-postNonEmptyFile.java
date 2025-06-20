/** 
 * Make a POST request with a non-empty request body
 * @throws Exception
 */
@Test public void postNonEmptyFile() throws Exception {
handler=new RequestHandler()//RW
body.set(new String(read()));
new FileWriter(file).append("hello").close();
int code=post(url).send(file).code();//RW
assertEquals(HTTP_OK,code);
assertEquals("hello",body.get());
}