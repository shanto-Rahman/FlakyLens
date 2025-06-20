/** 
 * Get header parameter value
 * @throws Exception
 */
@Test public void getParameterFromMissingHeader() throws Exception {
handler=new RequestHandler()//RW
HttpRequest request=get(url);//RW
assertTrue(request.ok());
assertNull(request.parameter("b","c"));
assertTrue(request.parameters("b").isEmpty());
}