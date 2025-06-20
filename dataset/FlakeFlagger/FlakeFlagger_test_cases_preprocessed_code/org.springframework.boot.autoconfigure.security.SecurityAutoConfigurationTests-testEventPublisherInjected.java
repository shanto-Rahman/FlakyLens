@Test public void testEventPublisherInjected() throws Exception {
fail("Expected BadCredentialsException");
assertTrue(wrapper.get() instanceof AuthenticationFailureBadCredentialsEvent);
}