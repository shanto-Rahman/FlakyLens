/** 
 * Verify 'ETag' header
 * @throws Exception
 */
@Test public void eTagHeader() throws Exception {
handler=new RequestHandler()//RW
assertEquals("abcd",get(url).eTag());//RW
}