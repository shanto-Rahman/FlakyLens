/** 
 * Make a HEAD request with an empty body response
 * @throws Exception
 */
@Test public void headUrlEmpty() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=head(new URL(url));//RW
assertNotNull(request.getConnection());
assertTrue(request.ok());
assertFalse(request.notFound());
assertEquals("HEAD",method.get());
assertEquals("",request.body());
}