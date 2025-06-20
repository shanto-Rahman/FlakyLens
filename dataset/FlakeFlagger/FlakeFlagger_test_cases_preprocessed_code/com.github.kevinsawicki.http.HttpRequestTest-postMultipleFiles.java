/** 
 * Make a POST request with multiple files in the body
 * @throws Exception
 */
@Test public void postMultipleFiles() throws Exception {
handler=new RequestHandler()//RW
body.set(new String(read()));
new FileWriter(file1).append("hello").close();
new FileWriter(file2).append(" world").close();
int code=post(url).send(file1).send(file2).code();//RW
assertEquals(HTTP_OK,code);
assertEquals("hello world",body.get());
}