/** 
 * Verify progress callback when sending from a Reader
 * @throws Exception
 */
@Test public void uploadProgressSendReader() throws Exception {
handler=new RequestHandler()//RW
body.set(new String(read()));
assertEquals(-1,total);
assertEquals(tx.incrementAndGet(),transferred);
new FileWriter(file).append("hello").close();
post(url).progress(progress).bufferSize(1).send(new FileReader(file)).code();//RW
assertEquals(file.length(),tx.get());
}