/** 
 * Verify sending form data where entry value is null
 * @throws Exception
 */
@Test public void postFormEntryWithNullValue() throws Exception {
handler=new RequestHandler()//RW
body.set(new String(read()));
HttpRequest request=post(url);//RW
assertEquals(HTTP_OK,code);
assertEquals("name=",body.get());
}