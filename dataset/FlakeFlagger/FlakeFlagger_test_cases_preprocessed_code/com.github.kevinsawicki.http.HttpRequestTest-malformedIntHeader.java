/** 
 * Verify getting int header with default value
 * @throws Exception
 */
@Test public void malformedIntHeader() throws Exception {
handler=new RequestHandler()//RW
assertEquals(4321,get(url).intHeader("malformed",4321));//RW
}