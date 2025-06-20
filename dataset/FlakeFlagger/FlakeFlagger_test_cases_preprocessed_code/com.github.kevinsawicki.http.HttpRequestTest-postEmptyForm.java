/** 
 * Make a post with an empty form data map
 * @throws Exception
 */
@Test public void postEmptyForm() throws Exception {
handler=new RequestHandler()//RW
body.set(new String(read()));
int code=post(url).form(new HashMap<String,String>()).code();//RW
assertEquals(HTTP_OK,code);
assertEquals("",body.get());
}