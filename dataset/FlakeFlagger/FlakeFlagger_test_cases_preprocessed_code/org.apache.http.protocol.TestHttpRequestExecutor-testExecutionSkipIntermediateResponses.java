@Test public void testExecutionSkipIntermediateResponses() throws Exception {
Assert.assertSame(conn,context.getAttribute(ExecutionContext.HTTP_CONNECTION));
Assert.assertSame(request,context.getAttribute(ExecutionContext.HTTP_REQUEST));
Assert.assertSame(response,context.getAttribute(ExecutionContext.HTTP_RESPONSE));
}