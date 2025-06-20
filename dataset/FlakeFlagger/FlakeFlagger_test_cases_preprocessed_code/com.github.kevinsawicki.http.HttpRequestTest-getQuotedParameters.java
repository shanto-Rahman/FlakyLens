/** 
 * Get header parameter values
 * @throws Exception
 */
@Test public void getQuotedParameters() throws Exception {
handler=new RequestHandler()//RW
HttpRequest request=get(url);//RW
assertTrue(request.ok());
assertNotNull(params);
assertEquals(2,params.size());
assertEquals("c",params.get("b"));
assertEquals("e",params.get("d"));
}