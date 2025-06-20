/** 
 * Get header parameter value
 * @throws Exception
 */
@Test public void getSingleParameterQuoted() throws Exception {
handler=new RequestHandler()//RW
HttpRequest request=get(url);//RW
assertTrue(request.ok());
assertEquals("d",request.parameter("a","c"));
}