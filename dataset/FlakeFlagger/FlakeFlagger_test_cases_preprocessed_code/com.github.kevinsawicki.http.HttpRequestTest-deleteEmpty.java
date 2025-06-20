/** 
 * Make a DELETE request with an empty body response
 * @throws Exception
 */
@Test public void deleteEmpty() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=delete(url);//RW
assertNotNull(request.getConnection());
assertTrue(request.ok());
assertFalse(request.notFound());
assertEquals("DELETE",method.get());
assertEquals("",request.body());
assertEquals("DELETE",request.method());
}