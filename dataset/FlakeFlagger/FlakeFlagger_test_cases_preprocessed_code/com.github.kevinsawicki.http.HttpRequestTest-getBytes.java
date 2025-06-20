/** 
 * Make a GET and get response body as byte array
 * @throws Exception
 */
@Test public void getBytes() throws Exception {
handler=new RequestHandler()//RW
HttpRequest request=get(url);//RW
assertTrue(request.ok());
assertTrue(Arrays.equals("hello".getBytes(),request.bytes()));
}