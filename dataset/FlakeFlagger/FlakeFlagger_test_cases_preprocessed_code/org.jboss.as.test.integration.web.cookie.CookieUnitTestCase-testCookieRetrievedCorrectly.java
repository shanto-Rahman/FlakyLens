@Test public void testCookieRetrievedCorrectly() throws Exception {
log.trace("testCookieRetrievedCorrectly()");//RW
assertTrue("Wrong response code: " + postStatusCode,postStatusCode == HttpURLConnection.HTTP_OK);
assertTrue("X-Exception(" + Arrays.toString(postErrorHeaders) + ") is null",postErrorHeaders.length == 0);
assertTrue("Sever did not set expired cookie on client",checkNoExpiredCookie(cookies));
log.trace("Cookie : " + cookie);//RW
if (cookieName.equals("simpleCookie")) {
assertTrue("cookie value should be jboss",cookieValue.equals("jboss"));
assertEquals("cookie path","/jbosstest-cookie",cookie.getPath());
assertEquals("cookie persistence",false,cookie.isPersistent());
if (cookieName.equals("withSpace")) {
assertEquals("should be no quote in cookie with space",cookieValue.indexOf("\""),-1);
if (cookieName.equals("comment")) {
log.trace("comment in cookie: " + cookie.getComment());//RW
assertTrue(cookie.getComment() == null);
if (cookieName.equals("withComma")) {
assertTrue("should contain a comma",cookieValue.indexOf(",") != -1);
if (cookieName.equals("expireIn10Sec")) {
log.trace("will sleep for 5 seconds to see if cookie expires");//RW
assertTrue("cookies should not be expired by now",!cookie.isExpired(new Date(now.getTime() + fiveSeconds)));
log.trace("will sleep for 5 more secs and it should expire");//RW
assertTrue("cookies should be expired by now",cookie.isExpired(new Date(now.getTime() + 2 * fiveSeconds)));
}
}
}
}
}
}