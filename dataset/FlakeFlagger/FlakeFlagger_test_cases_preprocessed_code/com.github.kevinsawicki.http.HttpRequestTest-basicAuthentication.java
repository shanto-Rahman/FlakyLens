/** 
 * Make a GET request with basic authentication specified
 * @throws Exception
 */
@Test public void basicAuthentication() throws Exception {
handler=new RequestHandler()//RW
user.set(auth.substring(0,colon));
password.set(auth.substring(colon + 1));
assertTrue(get(url).basic("user","p4ssw0rd").ok());//RW
assertEquals("user",user.get());
assertEquals("p4ssw0rd",password.get());
}