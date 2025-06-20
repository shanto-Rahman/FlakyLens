/** 
 * Verify PUT with query parameters
 * @throws Exception
 */
@Test public void putWithVarargsQueryParams() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=put(url,false,"name","user","number","100");//RW
assertTrue(request.ok());
assertEquals("PUT",method.get());
assertEquals("user",outputParams.get("name"));
assertEquals("100",outputParams.get("number"));
}