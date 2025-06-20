/** 
 * Verify progress callback when sending from an InputStream
 * @throws Exception
 */
@Test public void uploadProgressSendInputStream() throws Exception {
handler=new RequestHandler()//RW
body.set(new String(read()));
new FileWriter(file).append("hello").close();
InputStream input=new FileInputStream(file);
assertEquals(-1,total);
assertEquals(tx.incrementAndGet(),transferred);
post(url).bufferSize(1).progress(progress).send(input).code();//RW
assertEquals(file.length(),tx.get());
}