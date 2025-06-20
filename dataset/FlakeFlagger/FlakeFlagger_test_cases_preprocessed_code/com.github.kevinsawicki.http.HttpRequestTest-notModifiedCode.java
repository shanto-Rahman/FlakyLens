/** 
 * Get a 304
 * @throws Exception
 */
@Test public void notModifiedCode() throws Exception {
handler=new RequestHandler()//RW
HttpRequest request=get(url);//RW
assertNotNull(request);
assertTrue(request.notModified());
}