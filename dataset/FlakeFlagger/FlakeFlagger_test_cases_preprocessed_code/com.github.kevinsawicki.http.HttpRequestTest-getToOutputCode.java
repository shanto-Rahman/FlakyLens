/** 
 * Make a GET request and get the code using an    {@link AtomicInteger}
 * @throws Exception
 */
@Test public void getToOutputCode() throws Exception {
handler=new RequestHandler()//RW
get(url).code(code);//RW
assertEquals(HTTP_OK,code.get());
}