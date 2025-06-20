/** 
 * Verify response in    {@link File}
 * @throws Exception
 */
@Test public void receiveFile() throws Exception {
handler=new RequestHandler()//RW
fail();
assertTrue(post(url).receive(output).ok());//RW
BufferedReader reader=new BufferedReader(new FileReader(output));
assertEquals("content",buffer.toString());
}