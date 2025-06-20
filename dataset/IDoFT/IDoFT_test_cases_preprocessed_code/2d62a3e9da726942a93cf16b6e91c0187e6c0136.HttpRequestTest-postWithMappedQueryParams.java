/** 
 * Verify POST with query parameters
 * @throws Exception
 */
@Test public void postWithMappedQueryParams() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=post(url,inputParams,false);//RW
assertTrue(request.ok());
assertEquals("POST",method.get());
assertEquals("user",outputParams.get("name"));
assertEquals("100",outputParams.get("number"));
}