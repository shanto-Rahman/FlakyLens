/** 
 * Get header with multiple response values
 * @throws Exception
 */
@Test public void getHeaders() throws Exception {
handler=new RequestHandler()//RW
HttpRequest request=get(url);//RW
assertTrue(request.ok());
assertNotNull(values);
assertEquals(2,values.length);
assertTrue(Arrays.asList(values).contains("1"));
assertTrue(Arrays.asList(values).contains("2"));
}