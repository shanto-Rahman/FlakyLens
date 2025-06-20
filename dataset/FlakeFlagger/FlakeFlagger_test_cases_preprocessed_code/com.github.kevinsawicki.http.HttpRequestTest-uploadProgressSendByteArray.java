/** 
 * Verify progress callback when sending from a byte array
 * @throws Exception
 */
@Test public void uploadProgressSendByteArray() throws Exception {
handler=new RequestHandler()//RW
body.set(new String(read()));
assertEquals(bytes.length,total);
assertEquals(tx.incrementAndGet(),transferred);
post(url).bufferSize(1).progress(progress).send(bytes).code();//RW
assertEquals(bytes.length,tx.get());
}