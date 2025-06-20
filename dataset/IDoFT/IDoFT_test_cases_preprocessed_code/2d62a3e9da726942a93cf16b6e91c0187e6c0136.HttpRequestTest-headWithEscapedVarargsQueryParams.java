/** 
 * Verify HEAD with escaped query parameters
 * @throws Exception
 */
@Test public void headWithEscapedVarargsQueryParams() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=head(url,true,"name","us er","number","100");//RW
assertTrue(request.ok());
assertEquals("HEAD",method.get());
assertEquals("us er",outputParams.get("name"));
assertEquals("100",outputParams.get("number"));
}