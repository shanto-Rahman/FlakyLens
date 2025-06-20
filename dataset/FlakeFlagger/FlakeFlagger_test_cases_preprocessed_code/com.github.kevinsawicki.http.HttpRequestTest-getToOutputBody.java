/** 
 * Make a GET request and get the body using an    {@link AtomicReference}
 * @throws Exception
 */
@Test public void getToOutputBody() throws Exception {
handler=new RequestHandler()//RW
fail();
get(url).body(body);//RW
assertEquals("hello world",body.get());
}