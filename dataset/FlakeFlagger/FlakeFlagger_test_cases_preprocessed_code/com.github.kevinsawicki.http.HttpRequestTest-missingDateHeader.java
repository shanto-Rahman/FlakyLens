/** 
 * Verify getting date header with default value
 * @throws Exception
 */
@Test public void missingDateHeader() throws Exception {
handler=new RequestHandler()//RW
assertEquals(1234L,get(url).dateHeader("missing",1234L));//RW
}