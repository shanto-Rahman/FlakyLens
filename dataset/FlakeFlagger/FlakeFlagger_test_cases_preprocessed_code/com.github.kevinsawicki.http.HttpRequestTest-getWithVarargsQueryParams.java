/** 
 * Verify GET with query parameters
 * @throws Exception
 */
@Test public void getWithVarargsQueryParams() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=get(url,false,"name","user","number","100");//RW
assertTrue(request.ok());
assertEquals("GET",method.get());
assertEquals("user",outputParams.get("name"));
assertEquals("100",outputParams.get("number"));
}