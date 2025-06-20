/** 
 * Make a POST request with a non-empty request body
 * @throws Exception
 */
@Test public void postNonEmptyReader() throws Exception {
handler=new RequestHandler()//RW
body.set(new String(read()));
new FileWriter(file).append("hello").close();
int code=post(url).send(new FileReader(file)).code();//RW
assertEquals(HTTP_OK,code);
assertEquals("hello",body.get());
}