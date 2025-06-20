/** 
 * Verify progress callback when sending a file
 * @throws Exception
 */
@Test public void uploadProgressSend() throws Exception {
handler=new RequestHandler()//RW
body.set(new String(read()));
new FileWriter(file).append("hello").close();
assertEquals(file.length(),total);
assertEquals(tx.incrementAndGet(),transferred);
post(url).bufferSize(1).progress(progress).send(file).code();//RW
assertEquals(file.length(),tx.get());
}