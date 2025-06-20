/** 
 * Verify response via a    {@link PrintStream}
 * @throws Exception
 */
@Test public void receivePrintStream() throws Exception {
handler=new RequestHandler()//RW
fail();
assertTrue(post(url).receive(stream).ok());//RW
assertEquals("content",output.toString(CHARSET_UTF8));
}