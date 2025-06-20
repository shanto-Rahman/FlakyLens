/** 
 * Make a GET request with basic proxy authentication specified
 * @throws Exception
 */
@Test public void basicProxyAuthentication() throws Exception {
handler=new RequestHandler()//RW
finalHostReached.set(true);
assertTrue(get(url).useProxy("localhost",proxyPort).proxyBasic("user","p4ssw0rd").ok());//RW
assertEquals("user",proxyUser.get());
assertEquals("p4ssw0rd",proxyPassword.get());
assertEquals(true,finalHostReached.get());
assertEquals(1,proxyHitCount.get());
}