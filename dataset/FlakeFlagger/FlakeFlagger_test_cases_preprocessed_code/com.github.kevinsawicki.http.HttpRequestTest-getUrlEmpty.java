/** 
 * Make a GET request with an empty body response
 * @throws Exception
 */
@Test public void getUrlEmpty() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=get(new URL(url));//RW
assertNotNull(request.getConnection());
assertTrue(request.ok());
assertFalse(request.created());
assertFalse(request.noContent());
assertFalse(request.badRequest());
assertFalse(request.serverError());
assertFalse(request.notFound());
assertEquals("GET",method.get());
assertEquals("OK",request.message());
assertEquals(HTTP_OK,code);
assertEquals("",request.body());
}