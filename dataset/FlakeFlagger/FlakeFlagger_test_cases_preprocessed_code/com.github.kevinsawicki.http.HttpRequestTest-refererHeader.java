/** 
 * Verify 'Referer' header
 * @throws Exception
 */
@Test public void refererHeader() throws Exception {
handler=new RequestHandler()//RW
referer.set(request.getHeader("Referer"));
assertTrue(post(url).referer("http://heroku.com").ok());//RW
assertEquals("http://heroku.com",referer.get());
}