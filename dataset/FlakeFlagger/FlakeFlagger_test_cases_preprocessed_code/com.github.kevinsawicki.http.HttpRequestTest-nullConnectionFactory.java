/** 
 * Verify setting a null connection factory restores to the default one
 */
@Test public void nullConnectionFactory() throws Exception {
handler=new RequestHandler()//RW
int code=get(url).code();//RW
assertEquals(200,code);
}