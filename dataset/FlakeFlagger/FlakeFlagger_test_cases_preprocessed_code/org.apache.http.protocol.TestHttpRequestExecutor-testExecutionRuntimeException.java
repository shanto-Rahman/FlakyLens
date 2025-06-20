@Test public void testExecutionRuntimeException() throws Exception {
Assert.fail("IOException should have been thrown");
Assert.assertEquals(Boolean.TRUE,context.getAttribute(ExecutionContext.HTTP_REQ_SENT));
}