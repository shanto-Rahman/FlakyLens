/** 
 * Verify getting all headers
 * @throws Exception
 */
@Test public void getAllHeaders() throws Exception {
handler=new RequestHandler()//RW
Map<String,List<String>> headers=get(url).headers();//RW
assertEquals(headers.size(),5);
assertEquals(headers.get("a").size(),2);
assertTrue(headers.get("b").get(0).equals("b"));
}