/** 
 * Verify getting date header with default value
 * @throws Exception
 */
@Test public void malformedDateHeader() throws Exception {
handler=new RequestHandler()//RW
assertEquals(1234L,get(url).dateHeader("malformed",1234L));//RW
}