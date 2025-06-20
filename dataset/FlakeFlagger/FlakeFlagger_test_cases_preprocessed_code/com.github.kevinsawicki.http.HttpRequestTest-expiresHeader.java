/** 
 * Verify 'Expires' header
 * @throws Exception
 */
@Test public void expiresHeader() throws Exception {
handler=new RequestHandler()//RW
assertEquals(1234000,get(url).expires());//RW
}