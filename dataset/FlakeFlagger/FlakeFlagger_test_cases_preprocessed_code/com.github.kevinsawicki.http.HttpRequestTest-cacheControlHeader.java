/** 
 * Verify 'Cache-Control' header
 * @throws Exception
 */
@Test public void cacheControlHeader() throws Exception {
handler=new RequestHandler()//RW
assertEquals("no-cache",get(url).cacheControl());//RW
}