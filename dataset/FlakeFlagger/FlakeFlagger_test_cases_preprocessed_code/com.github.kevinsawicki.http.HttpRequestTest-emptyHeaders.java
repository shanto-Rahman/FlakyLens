/** 
 * Verify setting headers
 * @throws Exception
 */
@Test public void emptyHeaders() throws Exception {
handler=new RequestHandler()//RW
assertTrue(get(url).headers(Collections.<String,String>emptyMap()).ok());//RW
}