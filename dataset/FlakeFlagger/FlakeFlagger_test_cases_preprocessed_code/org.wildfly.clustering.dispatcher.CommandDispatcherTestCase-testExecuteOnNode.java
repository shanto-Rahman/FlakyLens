@Test public void testExecuteOnNode() throws CommandDispatcherException {
future.complete(result);
assertSame(result,response.get());
fail(e.getMessage());
future.obtrudeException(exception);
fail("Expected exception");
assertSame(exception,e.getCause());
future.obtrudeException(exception);
fail("Expected exception");
assertSame(exception,e);
fail(e.getMessage());
}