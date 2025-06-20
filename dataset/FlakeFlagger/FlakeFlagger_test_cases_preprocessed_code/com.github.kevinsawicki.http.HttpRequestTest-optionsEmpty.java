/** 
 * Make an OPTIONS request with an empty body response
 * @throws Exception
 */
@Test public void optionsEmpty() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=options(url);//RW
assertNotNull(request.getConnection());
assertTrue(request.ok());
assertFalse(request.notFound());
assertEquals("OPTIONS",method.get());
assertEquals("",request.body());
}