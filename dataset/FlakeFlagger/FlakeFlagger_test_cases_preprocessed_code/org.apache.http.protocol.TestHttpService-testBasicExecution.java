@Test public void testBasicExecution() throws Exception {
Assert.assertEquals(HttpStatus.SC_NOT_IMPLEMENTED,response.getStatusLine().getStatusCode());
Assert.assertSame(conn,context.getAttribute(ExecutionContext.HTTP_CONNECTION));
Assert.assertSame(request,context.getAttribute(ExecutionContext.HTTP_REQUEST));
Assert.assertSame(response,context.getAttribute(ExecutionContext.HTTP_RESPONSE));
}