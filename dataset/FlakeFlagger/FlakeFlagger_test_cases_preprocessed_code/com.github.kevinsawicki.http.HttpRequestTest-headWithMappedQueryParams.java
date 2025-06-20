/** 
 * Verify HEAD with query parameters
 * @throws Exception
 */
@Test public void headWithMappedQueryParams() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=head(url,inputParams,false);//RW
assertTrue(request.ok());
assertEquals("HEAD",method.get());
assertEquals("user",outputParams.get("name"));
assertEquals("100",outputParams.get("number"));
}