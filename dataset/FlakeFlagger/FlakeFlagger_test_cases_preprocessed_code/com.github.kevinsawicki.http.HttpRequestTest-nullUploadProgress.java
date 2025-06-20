/** 
 * Verify progress callback doesn't cause an exception when it's null
 * @throws Exception
 */
@Test public void nullUploadProgress() throws Exception {
handler=new RequestHandler()//RW
body.set(new String(read()));
new FileWriter(file).append("hello").close();
int code=post(url).progress(null).send(file).code();//RW
assertEquals(HTTP_OK,code);
assertEquals("hello",body.get());
}