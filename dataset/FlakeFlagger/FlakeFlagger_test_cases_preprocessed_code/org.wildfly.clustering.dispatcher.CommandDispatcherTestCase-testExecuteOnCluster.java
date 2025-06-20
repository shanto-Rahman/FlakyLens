@Test public void testExecuteOnCluster() throws CommandDispatcherException {
CompletableFuture<Object> completedFuture=CompletableFuture.completedFuture(result);
exceptionFuture.completeExceptionally(exception);
cancelledFuture.cancel(false);
assertNotNull(responses.get(completedMember));
assertNotNull(responses.get(exceptionMember));
assertNull(responses.get(cancelledMember));
assertSame(result,responses.get(completedMember).get());
fail(e.getMessage());
assertSame(result,responses.get(exceptionMember).get());
fail("Expected exception");
assertSame(exception,e.getCause());
}