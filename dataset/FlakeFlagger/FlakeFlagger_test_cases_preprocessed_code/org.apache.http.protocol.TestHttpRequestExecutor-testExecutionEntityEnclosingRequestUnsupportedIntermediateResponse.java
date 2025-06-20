@Test public void testExecutionEntityEnclosingRequestUnsupportedIntermediateResponse() throws Exception {
Assert.fail("ProtocolException should have been thrown");
Assert.assertEquals(Boolean.FALSE,context.getAttribute(ExecutionContext.HTTP_REQ_SENT));
}