/** 
 * Verify 'Content-Type' header
 * @throws Exception
 */
@Test public void contentTypeHeader() throws Exception {
handler=new RequestHandler()//RW
assertEquals("text/html",get(url).contentType());//RW
}