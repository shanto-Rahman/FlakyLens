/** 
 * Make a TRACE request with an empty body response
 * @throws Exception
 */
@Test public void traceUrlEmpty() throws Exception {
handler=new RequestHandler()//RW
method.set(request.getMethod());
HttpRequest request=trace(new URL(url));//RW
assertNotNull(request.getConnection());
assertTrue(request.ok());
assertFalse(request.notFound());
assertEquals("TRACE",method.get());
assertEquals("",request.body());
}