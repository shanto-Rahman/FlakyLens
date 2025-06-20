/** 
 * Get a 400
 * @throws Exception
 */
@Test public void badRequestCode() throws Exception {
handler=new RequestHandler()//RW
HttpRequest request=get(url);//RW
assertNotNull(request);
assertTrue(request.badRequest());
}