@Test public void testExecutionExceptionInCustomExpectationVerifier() throws Exception {
Assert.assertSame(conn,context.getAttribute(ExecutionContext.HTTP_CONNECTION));
Assert.assertSame(request,context.getAttribute(ExecutionContext.HTTP_REQUEST));
Assert.assertSame(response,context.getAttribute(ExecutionContext.HTTP_RESPONSE));
Assert.assertEquals(HttpStatus.SC_INTERNAL_SERVER_ERROR,response.getStatusLine().getStatusCode());
}