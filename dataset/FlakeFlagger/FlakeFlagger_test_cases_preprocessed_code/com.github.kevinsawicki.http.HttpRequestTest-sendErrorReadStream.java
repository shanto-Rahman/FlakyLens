/** 
 * Send a stream that throws an exception when read from
 * @throws Exception
 */
@Test public void sendErrorReadStream() throws Exception {
handler=new RequestHandler()//RW
fail();
post(url).send(stream);//RW
fail("Exception not thrown");
assertEquals(readCause,e.getCause());
}