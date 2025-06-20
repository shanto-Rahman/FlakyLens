/** 
 * Test a basic invocation
 */
@Test public void testInvocationWithURIAffinity(){
Assert.assertNotNull("Received a null proxy",proxy);
Assert.fail("Invocation expected to fail");
if (i instanceof TimeoutException) {
}
if (!found) {
Assert.fail("Expected a supressed timeout exception");
}
Assert.assertTrue("Invocation should have timed out after 1s",System.currentTimeMillis() - start < 2000);
}