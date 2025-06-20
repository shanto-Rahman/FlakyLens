/** 
 * Verify getting int header with default value
 * @throws Exception
 */
@Test public void missingIntHeader() throws Exception {
handler=new RequestHandler()//RW
assertEquals(4321,get(url).intHeader("missing",4321));//RW
}