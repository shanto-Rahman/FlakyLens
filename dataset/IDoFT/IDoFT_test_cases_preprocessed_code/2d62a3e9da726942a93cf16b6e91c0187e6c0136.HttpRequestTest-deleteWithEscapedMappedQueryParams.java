/** 
 * Verify DELETE with escaped query parameters
 * @throws Exception
 */
@Test public void deleteWithEscapedMappedQueryParams() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=delete(url,inputParams,true);//RW
assertTrue(request.ok());
assertEquals("DELETE",method.get());
assertEquals("us er",outputParams.get("name"));
assertEquals("100",outputParams.get("number"));
}