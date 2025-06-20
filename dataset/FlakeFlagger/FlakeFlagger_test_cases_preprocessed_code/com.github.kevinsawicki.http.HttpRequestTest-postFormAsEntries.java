/** 
 * Verify sending form data as a sequence of    {@link Entry}  objects
 * @throws Exception
 */
@Test public void postFormAsEntries() throws Exception {
handler=new RequestHandler()//RW
body.set(new String(read()));
HttpRequest request=post(url);//RW
assertEquals(HTTP_OK,code);
assertEquals("name=user&number=100",body.get());
}