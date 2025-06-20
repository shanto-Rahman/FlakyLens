/** 
 * Test that a bad login is redirected to the errors.jsp and that the session j_exception is not null.
 */
@Test @OperateOnDeployment("form-auth.war") public void testFormAuthException() throws Exception {
log.trace("+++ testFormAuthException");//RW
log.trace("Executing request " + httpget.getRequestLine());//RW
assertTrue("Wrong response code: " + statusCode,statusCode == HttpURLConnection.HTTP_OK);
assertTrue("X-NoJException(" + Arrays.toString(errorHeaders) + ") is null",errorHeaders.length == 0);
if ((entity != null) && (entity.getContentLength() > 0)) {
assertTrue("Redirected to login page",body.indexOf("j_security_check") > 0);
fail("Empty body in response");
}
if (k.getName().equalsIgnoreCase("JSESSIONID")) sessionID=k.getValue();
log.trace("Saw JSESSIONID=" + sessionID);//RW
log.trace("Executing request " + formPost.getRequestLine());//RW
assertTrue("Should see HTTP_OK. Got " + statusCode,statusCode == HttpURLConnection.HTTP_OK);
assertTrue("X-NoJException(" + Arrays.toString(errorHeaders) + ") is not null",errorHeaders.length != 0);
log.debug("Saw X-JException, " + Arrays.toString(errorHeaders));//RW
}