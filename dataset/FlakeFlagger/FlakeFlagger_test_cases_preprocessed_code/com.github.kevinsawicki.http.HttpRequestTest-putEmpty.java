/** 
 * Make a PUT request with an empty body response
 * @throws Exception
 */
@Test public void putEmpty() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=put(url);//RW
assertNotNull(request.getConnection());
assertTrue(request.ok());
assertFalse(request.notFound());
assertEquals("PUT",method.get());
assertEquals("",request.body());
}