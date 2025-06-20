/** 
 * Verify DELETE with query parameters
 * @throws Exception
 */
@Test public void deleteWithMappedQueryParams() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=delete(url,inputParams,false);//RW
assertTrue(request.ok());
assertEquals("DELETE",method.get());
assertEquals("user",outputParams.get("name"));
assertEquals("100",outputParams.get("number"));
}