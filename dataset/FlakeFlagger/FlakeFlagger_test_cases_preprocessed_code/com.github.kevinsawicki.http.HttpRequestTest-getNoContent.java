/** 
 * Make a GET request with an empty body response
 * @throws Exception
 */
@Test public void getNoContent() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=get(new URL(url));//RW
assertNotNull(request.getConnection());
assertFalse(request.ok());
assertFalse(request.created());
assertTrue(request.noContent());
assertFalse(request.badRequest());
assertFalse(request.serverError());
assertFalse(request.notFound());
assertEquals("GET",method.get());
assertEquals("No Content",request.message());
assertEquals(HTTP_NO_CONTENT,code);
assertEquals("",request.body());
}