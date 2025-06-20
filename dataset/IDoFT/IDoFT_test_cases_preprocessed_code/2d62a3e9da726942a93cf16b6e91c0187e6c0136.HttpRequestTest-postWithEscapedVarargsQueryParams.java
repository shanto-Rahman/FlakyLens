/** 
 * Verify POST with escaped query parameters
 * @throws Exception
 */
@Test public void postWithEscapedVarargsQueryParams() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=post(url,true,"name","us er","number","100");//RW
assertTrue(request.ok());
assertEquals("POST",method.get());
assertEquals("us er",outputParams.get("name"));
assertEquals("100",outputParams.get("number"));
}