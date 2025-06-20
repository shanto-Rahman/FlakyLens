/** 
 * Verify setting number header
 * @throws Exception
 */
@Test public void numberHeader() throws Exception {
handler=new RequestHandler()//RW
h1.set(request.getHeader("h1"));
h2.set(request.getHeader("h2"));
assertTrue(get(url).header("h1",5).header("h2",(Number)null).ok());//RW
assertEquals("5",h1.get());
assertEquals("",h2.get());
}