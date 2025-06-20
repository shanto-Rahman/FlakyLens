/** 
 * Make a GET request and get the body using an    {@link AtomicReference}
 * @throws Exception
 */
@Test public void getToOutputBodyWithCharset() throws Exception {
handler=new RequestHandler()//RW
fail();
get(url).body(body,CHARSET_UTF8);//RW
assertEquals("hello world",body.get());
}