/** 
 * Test that a post from an unsecured form to a secured servlet does not loose its data during the redirect to the form login.
 */
@Test @OperateOnDeployment("form-auth.war") public void testPostDataFormAuth() throws Exception {
log.trace("+++ testPostDataFormAuth");//RW
log.trace("Executing request " + httpget.getRequestLine());//RW
assertTrue("Wrong response code: " + statusCode,statusCode == HttpURLConnection.HTTP_OK);
assertTrue("X-NoJException(" + Arrays.toString(errorHeaders) + ") is null",errorHeaders.length == 0);
log.trace("Executing request " + restrictedPost.getRequestLine());//RW
assertTrue("Wrong response code: " + statusCode,statusCode == HttpURLConnection.HTTP_OK);
assertTrue("X-NoJException(" + Arrays.toString(errorHeaders) + ") is null",errorHeaders.length == 0);
if ((entity != null) && (entity.getContentLength() > 0)) {
assertTrue("Redirected to login page",body.indexOf("j_security_check") > 0);
fail("Empty body in response");
}
if (k.getName().equalsIgnoreCase("JSESSIONID")) sessionID=k.getValue();
log.trace("Saw JSESSIONID=" + sessionID);//RW
log.trace("Executing request " + formPost.getRequestLine());//RW
assertTrue("Should see HTTP_MOVED_TEMP. Got " + statusCode,statusCode == HttpURLConnection.HTTP_MOVED_TEMP);
assertTrue("X-NoJException(" + Arrays.toString(errorHeaders) + ") is null",errorHeaders.length == 0);
log.trace("Executing request " + war1Index.getRequestLine());//RW
assertTrue("Wrong response code: " + statusCode,statusCode == HttpURLConnection.HTTP_OK);
assertTrue("X-NoJException(" + Arrays.toString(errorHeaders) + ") is null",errorHeaders.length == 0);
if ((war1Entity != null) && (entity.getContentLength() > 0)) {
if (body.indexOf("j_security_check") > 0) fail("Get of " + indexURI + " redirected to login page");
fail("Get of " + indexURI + " redirected to login page");
fail("Empty body in response");
}
}