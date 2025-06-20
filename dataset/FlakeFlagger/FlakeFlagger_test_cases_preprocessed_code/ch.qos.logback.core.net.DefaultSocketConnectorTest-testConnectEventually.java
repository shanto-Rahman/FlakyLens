@Test(timeout=5000) public void testConnectEventually() throws Exception {
Future<Socket> connectorTask=executor.submit(connector);
connectorTask.get(SHORT_DELAY,TimeUnit.MILLISECONDS);
fail();
Exception lastException=exceptionHandler.awaitConnectionFailed(DELAY);//IT
assertNotNull(lastException);
assertTrue(lastException instanceof ConnectException);
Socket socket=connectorTask.get(2 * DELAY,TimeUnit.MILLISECONDS);
assertNotNull(socket);
assertFalse(connectorTask.isCancelled());
}