@Test public void testSubmitOnNode() throws CommandDispatcherException {
future.complete(result);
assertSame(future,response);
}