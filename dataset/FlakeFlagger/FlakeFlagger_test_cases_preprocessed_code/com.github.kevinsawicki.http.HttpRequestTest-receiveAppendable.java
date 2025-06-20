/** 
 * Verify response in    {@link Appendable}
 * @throws Exception
 */
@Test public void receiveAppendable() throws Exception {
handler=new RequestHandler()//RW
fail();
assertTrue(post(url).receive(body).ok());//RW
assertEquals("content",body.toString());
}