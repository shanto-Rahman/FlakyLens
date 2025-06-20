/** 
 * Make a GET request with a URL that needs encoding
 * @throws Exception
 */
@Test public void getUrlEncodedWithPercent() throws Exception {
handler=new RequestHandler()//RW
path.set(request.getPathInfo());
HttpRequest request=get(encode(url + unencoded));//RW
assertTrue(request.ok());
assertEquals(unencoded,path.get());
}