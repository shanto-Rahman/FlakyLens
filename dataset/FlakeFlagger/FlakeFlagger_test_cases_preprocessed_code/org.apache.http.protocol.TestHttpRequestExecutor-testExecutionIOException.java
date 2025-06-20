@Test public void testExecutionIOException() throws Exception {
Assert.fail("IOException should have been thrown");
Assert.assertEquals(Boolean.FALSE,context.getAttribute(ExecutionContext.HTTP_REQ_SENT));
}