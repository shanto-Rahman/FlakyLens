/** 
 * Verify 'Location' header
 * @throws Exception
 */
@Test public void locationHeader() throws Exception {
handler=new RequestHandler()//RW
assertEquals("http://nowhere",get(url).location());//RW
}