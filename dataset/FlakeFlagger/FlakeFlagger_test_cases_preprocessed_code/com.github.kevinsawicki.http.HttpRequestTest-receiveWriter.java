/** 
 * Verify response in    {@link Writer}
 * @throws Exception
 */
@Test public void receiveWriter() throws Exception {
handler=new RequestHandler()//RW
fail();
assertTrue(post(url).receive(writer).ok());//RW
assertEquals("content",writer.toString());
}