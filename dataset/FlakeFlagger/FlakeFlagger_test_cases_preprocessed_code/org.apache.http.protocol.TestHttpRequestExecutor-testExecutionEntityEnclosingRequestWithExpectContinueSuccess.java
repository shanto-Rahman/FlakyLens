@Test public void testExecutionEntityEnclosingRequestWithExpectContinueSuccess() throws Exception {
Assert.assertEquals(Boolean.TRUE,context.getAttribute(ExecutionContext.HTTP_REQ_SENT));
}