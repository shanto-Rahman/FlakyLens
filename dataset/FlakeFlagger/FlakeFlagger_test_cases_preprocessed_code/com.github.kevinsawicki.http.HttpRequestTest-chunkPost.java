/** 
 * Make a post in chunked mode
 * @throws Exception
 */
@Test public void chunkPost() throws Exception {
handler=new RequestHandler()//RW
body.set(new String(read()));
encoding.set(request.getHeader("Transfer-Encoding"));
int code=post(url).chunk(2).send(data).code();//RW
assertEquals(HTTP_OK,code);
assertEquals(data,body.get());
assertEquals("chunked",encoding.get());
}