/** 
 * Verify POST with numeric query parameters
 * @throws Exception
 */
@Test public void postWithNumericQueryParams() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=post(url,inputParams,false);//RW
assertTrue(request.ok());
assertEquals("POST",method.get());
assertEquals("2",outputParams.get("1"));
assertEquals("4",outputParams.get("3"));
}