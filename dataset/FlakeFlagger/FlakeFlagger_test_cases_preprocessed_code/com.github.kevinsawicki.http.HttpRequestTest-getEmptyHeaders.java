/** 
 * Get header values when not set in response
 * @throws Exception
 */
@Test public void getEmptyHeaders() throws Exception {
handler=new RequestHandler()//RW
HttpRequest request=get(url);//RW
assertTrue(request.ok());
assertNotNull(values);
assertEquals(0,values.length);
}