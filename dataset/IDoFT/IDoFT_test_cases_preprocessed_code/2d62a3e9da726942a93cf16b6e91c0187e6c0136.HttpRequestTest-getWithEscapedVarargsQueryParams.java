/** 
 * Verify GET with escaped query parameters
 * @throws Exception
 */
@Test public void getWithEscapedVarargsQueryParams() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=get(url,true,"name","us er","number","100");//RW
assertTrue(request.ok());
assertEquals("GET",method.get());
assertEquals("us er",outputParams.get("name"));
assertEquals("100",outputParams.get("number"));
}