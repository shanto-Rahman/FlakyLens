/** 
 * Get a 500
 * @throws Exception
 */
@Test public void serverErrorCode() throws Exception {
handler=new RequestHandler()//RW
HttpRequest request=get(url);//RW
assertNotNull(request);
assertTrue(request.serverError());
}