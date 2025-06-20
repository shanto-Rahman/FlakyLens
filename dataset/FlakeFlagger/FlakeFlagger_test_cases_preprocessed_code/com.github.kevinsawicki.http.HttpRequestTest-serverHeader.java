/** 
 * Verify 'Server' header
 * @throws Exception
 */
@Test public void serverHeader() throws Exception {
handler=new RequestHandler()//RW
assertEquals("aserver",get(url).server());//RW
}