@Test public void testSubmitOnCluster() throws CommandDispatcherException {
CompletableFuture<Object> completedFuture=CompletableFuture.completedFuture(result);
exceptionFuture.completeExceptionally(exception);
cancelledFuture.cancel(false);
assertSame(completedFuture,responses.get(completedMember));
assertSame(exceptionFuture,responses.get(exceptionMember));
assertSame(cancelledFuture,responses.get(cancelledMember));
}