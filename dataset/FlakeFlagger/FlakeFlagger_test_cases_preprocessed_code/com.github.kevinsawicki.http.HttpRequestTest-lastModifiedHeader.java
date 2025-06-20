/** 
 * Verify 'Last-Modified' header
 * @throws Exception
 */
@Test public void lastModifiedHeader() throws Exception {
handler=new RequestHandler()//RW
assertEquals(555000,get(url).lastModified());//RW
}