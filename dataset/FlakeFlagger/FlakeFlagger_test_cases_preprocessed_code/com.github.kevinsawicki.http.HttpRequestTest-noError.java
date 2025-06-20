/** 
 * Make a GET request that returns an empty error string
 * @throws Exception
 */
@Test public void noError() throws Exception {
handler=new RequestHandler()//RW
HttpRequest request=get(url);//RW
assertTrue(request.ok());
assertEquals("",request.body());
}