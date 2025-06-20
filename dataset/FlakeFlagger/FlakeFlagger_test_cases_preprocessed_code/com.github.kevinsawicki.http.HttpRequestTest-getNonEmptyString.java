/** 
 * Make a GET request for a non-empty response body
 * @throws Exception
 */
@Test public void getNonEmptyString() throws Exception {
handler=new RequestHandler()//RW
HttpRequest request=get(url);//RW
assertEquals(HTTP_OK,request.code());
assertEquals("hello",request.body());
assertEquals("hello".getBytes().length,request.contentLength());
assertFalse(request.isBodyEmpty());
}