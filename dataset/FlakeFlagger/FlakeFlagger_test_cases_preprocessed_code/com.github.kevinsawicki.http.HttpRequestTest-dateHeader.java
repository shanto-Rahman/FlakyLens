/** 
 * Verify 'Date' header
 * @throws Exception
 */
@Test public void dateHeader() throws Exception {
handler=new RequestHandler()//RW
assertEquals(66000,get(url).date());//RW
}