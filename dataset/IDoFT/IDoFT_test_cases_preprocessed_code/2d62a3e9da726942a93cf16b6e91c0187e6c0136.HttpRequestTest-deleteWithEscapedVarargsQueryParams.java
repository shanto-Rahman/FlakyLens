/** 
 * Verify DELETE with escaped query parameters
 * @throws Exception
 */
@Test public void deleteWithEscapedVarargsQueryParams() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=delete(url,true,"name","us er","number","100");//RW
assertTrue(request.ok());
assertEquals("DELETE",method.get());
assertEquals("us er",outputParams.get("name"));
assertEquals("100",outputParams.get("number"));
}