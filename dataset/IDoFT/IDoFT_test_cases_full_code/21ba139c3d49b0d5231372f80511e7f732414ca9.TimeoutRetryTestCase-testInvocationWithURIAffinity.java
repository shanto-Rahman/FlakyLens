/** 
 * Test a basic invocation
 */
@Test public void testInvocationWithURIAffinity(){
  logger.info("Testing invocation on proxy with URIAffinity");
  final StatelessEJBLocator<Echo> statelessEJBLocator=new StatelessEJBLocator<Echo>(Echo.class,APP_NAME,MODULE_NAME,Echo.class.getSimpleName(),DISTINCT_NAME);
  final Echo proxy=EJBClient.createProxy(statelessEJBLocator);
  EJBClient.setInvocationTimeout(proxy,1,TimeUnit.SECONDS);
  URI uri=null;
  try {
    uri=new URI("remote",null,"localhost",6999,null,null,null);
  }
 catch (  URISyntaxException use) {
  }
  EJBClient.setStrongAffinity(proxy,URIAffinity.forUri(uri));
  Assert.assertNotNull("Received a null proxy",proxy);
  logger.info("Created proxy for Echo: " + proxy.toString());
  logger.info("Invoking on proxy...");
  final String message="hello!";
  long start=System.currentTimeMillis();
  try {
    proxy.echo(message);
    Assert.fail("Invocation expected to fail");
  }
 catch (  NoSuchEJBException expected) {
    boolean found=false;
    for (    Throwable i : expected.getSuppressed()) {
      if (i instanceof TimeoutException) {
        found=true;
        break;
      }
    }
    if (!found) {
      Assert.fail("Expected a supressed timeout exception");
    }
    expected.printStackTrace();
  }
  Assert.assertTrue("Invocation should have timed out after 1s",System.currentTimeMillis() - start < 2000);
}
