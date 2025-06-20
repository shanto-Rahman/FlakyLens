/** 
 * Send a stream that throws an exception when read from
 * @throws Exception
 */
@Test public void sendErrorCloseStream() throws Exception {
handler=new RequestHandler()//RW
fail();
post(url).ignoreCloseExceptions(false).send(stream);//RW
fail("Exception not thrown");
assertEquals(closeCause,e.getCause());
}