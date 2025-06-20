/** 
 * instruct vitim to use custom external resource locator (to return expected message).
 */
@Test public void shouldRedirectStreamWhenSendRedirectIsInvoked() throws Exception {
Assert.assertEquals(message,new String(redirectedStream.toByteArray()));
}