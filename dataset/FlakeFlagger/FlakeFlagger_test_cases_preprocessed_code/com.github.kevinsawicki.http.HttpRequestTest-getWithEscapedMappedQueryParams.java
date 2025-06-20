/** 
 * Verify GET with escaped query parameters
 * @throws Exception
 */
@Test public void getWithEscapedMappedQueryParams() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=get(url,inputParams,true);//RW
assertTrue(request.ok());
assertEquals("GET",method.get());
assertEquals("us er",outputParams.get("name"));
assertEquals("100",outputParams.get("number"));
}