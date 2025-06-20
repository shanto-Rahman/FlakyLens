/** 
 * Make a GET and get response as a input stream reader
 * @throws Exception
 */
@Test public void getReaderWithCharset() throws Exception {
handler=new RequestHandler()//RW
HttpRequest request=get(url);//RW
assertTrue(request.ok());
assertEquals("hello",reader.readLine());
}