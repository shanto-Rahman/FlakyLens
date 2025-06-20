/** 
 * Verify PUT with escaped query parameters
 * @throws Exception
 */
@Test public void putWithEscapedMappedQueryParams() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=put(url,inputParams,true);//RW
assertTrue(request.ok());
assertEquals("PUT",method.get());
assertEquals("us er",outputParams.get("name"));
assertEquals("100",outputParams.get("number"));
}