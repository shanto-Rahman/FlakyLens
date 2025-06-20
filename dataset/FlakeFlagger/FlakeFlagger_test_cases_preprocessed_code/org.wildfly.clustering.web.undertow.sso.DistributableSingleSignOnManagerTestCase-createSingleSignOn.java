@Test public void createSingleSignOn(){
assertNotNull(result);
assertNotNull(capturedAuthentication);
assertSame(capturedAuthentication.getAccount(),account);
assertSame(capturedAuthentication.getMechanism(),mechanism);
}