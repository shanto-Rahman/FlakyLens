/** 
 * Verify 'Content-Encoding' header
 * @throws Exception
 */
@Test public void contentEncodingHeader() throws Exception {
handler=new RequestHandler()//RW
assertEquals("gzip",get(url).contentEncoding());//RW
}