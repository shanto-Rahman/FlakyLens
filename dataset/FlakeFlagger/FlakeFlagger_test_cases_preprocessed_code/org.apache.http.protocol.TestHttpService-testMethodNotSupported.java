@Test public void testMethodNotSupported() throws Exception {
Assert.assertSame(conn,context.getAttribute(ExecutionContext.HTTP_CONNECTION));
Assert.assertSame(request,context.getAttribute(ExecutionContext.HTTP_REQUEST));
Assert.assertSame(error,context.getAttribute(ExecutionContext.HTTP_RESPONSE));
Assert.assertEquals(HttpStatus.SC_NOT_IMPLEMENTED,error.getStatusLine().getStatusCode());
}