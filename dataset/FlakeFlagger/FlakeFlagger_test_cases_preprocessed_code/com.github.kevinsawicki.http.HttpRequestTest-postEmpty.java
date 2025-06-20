/** 
 * Make a POST request with an empty request body
 * @throws Exception
 */
@Test public void postEmpty() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=post(url);//RW
assertEquals("POST",method.get());
assertFalse(request.ok());
assertTrue(request.created());
assertEquals(HTTP_CREATED,code);
}