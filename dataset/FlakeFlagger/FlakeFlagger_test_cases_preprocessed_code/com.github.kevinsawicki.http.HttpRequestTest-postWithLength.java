/** 
 * Make a post with an explicit set of the content length
 * @throws Exception
 */
@Test public void postWithLength() throws Exception {
handler=new RequestHandler()//RW
body.set(new String(read()));
length.set(request.getContentLength());
int code=post(url).contentLength(sent).send(data).code();//RW
assertEquals(HTTP_OK,code);
assertEquals(sent,length.get().intValue());
assertEquals(data,body.get());
}