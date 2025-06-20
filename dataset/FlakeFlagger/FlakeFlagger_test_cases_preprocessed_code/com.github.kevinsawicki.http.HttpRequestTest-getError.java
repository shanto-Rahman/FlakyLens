/** 
 * Make a GET request that returns an error string
 * @throws Exception
 */
@Test public void getError() throws Exception {
handler=new RequestHandler()//RW
HttpRequest request=get(url);//RW
assertTrue(request.notFound());
assertEquals("error",request.body());
}