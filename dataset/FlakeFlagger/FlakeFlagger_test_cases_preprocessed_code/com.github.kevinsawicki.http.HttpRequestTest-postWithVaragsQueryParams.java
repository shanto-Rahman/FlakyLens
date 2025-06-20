/** 
 * Verify POST with query parameters
 * @throws Exception
 */
@Test public void postWithVaragsQueryParams() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=post(url,false,"name","user","number","100");//RW
assertTrue(request.ok());
assertEquals("POST",method.get());
assertEquals("user",outputParams.get("name"));
assertEquals("100",outputParams.get("number"));
}