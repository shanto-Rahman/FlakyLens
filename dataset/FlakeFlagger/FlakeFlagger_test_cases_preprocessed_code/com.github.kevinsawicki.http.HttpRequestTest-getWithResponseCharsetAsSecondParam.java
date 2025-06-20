/** 
 * Make a GET request with a response that includes a charset parameter
 * @throws Exception
 */
@Test public void getWithResponseCharsetAsSecondParam() throws Exception {
handler=new RequestHandler()//RW
HttpRequest request=get(url);//RW
assertEquals(HTTP_OK,request.code());
assertEquals(CHARSET_UTF8,request.charset());
}