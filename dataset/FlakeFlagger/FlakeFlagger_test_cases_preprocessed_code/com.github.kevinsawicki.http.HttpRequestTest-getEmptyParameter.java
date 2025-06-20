/** 
 * Get header parameter value
 * @throws Exception
 */
@Test public void getEmptyParameter() throws Exception {
handler=new RequestHandler()//RW
HttpRequest request=get(url);//RW
assertTrue(request.ok());
assertNull(request.parameter("a","c"));
assertTrue(request.parameters("a").isEmpty());
}