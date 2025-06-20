/** 
 * Make a DELETE request with an empty body response
 * @throws Exception
 */
@Test public void deleteUrlEmpty() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=delete(new URL(url));//RW
assertNotNull(request.getConnection());
assertTrue(request.ok());
assertFalse(request.notFound());
assertEquals("DELETE",method.get());
assertEquals("",request.body());
}