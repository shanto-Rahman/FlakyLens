/** 
 * Make a post of form data
 * @throws Exception
 */
@Test public void postForm() throws Exception {
handler=new RequestHandler()//RW
body.set(new String(read()));
contentType.set(request.getContentType());
int code=post(url).form(data).form("zip","12345").code();//RW
assertEquals(HTTP_OK,code);
assertEquals("name=user&number=100&zip=12345",body.get());
assertEquals("application/x-www-form-urlencoded; charset=UTF-8",contentType.get());
}