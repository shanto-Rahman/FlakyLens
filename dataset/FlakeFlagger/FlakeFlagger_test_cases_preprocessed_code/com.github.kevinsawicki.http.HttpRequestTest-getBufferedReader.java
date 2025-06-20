/** 
 * Make a GET and get response as a buffered reader
 * @throws Exception
 */
@Test public void getBufferedReader() throws Exception {
handler=new RequestHandler()//RW
HttpRequest request=get(url);//RW
assertTrue(request.ok());
assertEquals("hello",reader.readLine());
}