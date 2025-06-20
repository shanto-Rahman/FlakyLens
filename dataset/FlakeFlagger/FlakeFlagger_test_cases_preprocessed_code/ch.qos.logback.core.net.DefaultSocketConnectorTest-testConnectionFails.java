@Test public void testConnectionFails() throws Exception {
Future<Socket> connectorTask=executor.submit(connector);
connectorTask.get(SHORT_DELAY,TimeUnit.MILLISECONDS);
fail();
Exception lastException=exceptionHandler.awaitConnectionFailed(DELAY);//IT
assertTrue(lastException instanceof ConnectException);
assertFalse(connectorTask.isDone());
connectorTask.cancel(true);
assertTrue(connectorTask.isCancelled());
}