/** 
 * Make a PUT request with an empty body response
 * @throws Exception
 */
@Test public void traceEmpty() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=trace(url);//RW
assertNotNull(request.getConnection());
assertTrue(request.ok());
assertFalse(request.notFound());
assertEquals("TRACE",method.get());
assertEquals("",request.body());
}