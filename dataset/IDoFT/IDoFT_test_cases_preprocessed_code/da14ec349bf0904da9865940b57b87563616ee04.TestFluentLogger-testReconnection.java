@Test public void testReconnection() throws Exception {
if (elist1.size() >= 1) break;
threadManager.submit(fluentd1);//IT
lastError.set(ex);
assertFalse(logger.isConnected());
assertTrue(logger.isConnected());
TimeUnit.MILLISECONDS.sleep(500);
TimeUnit.MILLISECONDS.sleep(500);
assertTrue(logger.isConnected());
assertNull(lastError.get());
assertTrue(lastError.get() instanceof IOException);
lastError.set(null);
assertFalse(logger.isConnected());
TimeUnit.MILLISECONDS.sleep((long)(ExponentialDelayReconnector.WAIT_MILLIS * 1.5));
assertNull(lastError.get());
lastError.set(null);
threadManager.submit(fluentd2);//IT
TimeUnit.MILLISECONDS.sleep((long)(ExponentialDelayReconnector.WAIT_MILLIS * 1.5));
assertNull(lastError.get());
assertTrue(logger.isConnected());
Thread.sleep(2000);
TimeUnit.MILLISECONDS.sleep(2000);
threadManager.join();//IT
assertNull(lastError.get());
assertEquals(1,elist1.size());
assertEquals("testtag.test01",elist1.get(0).tag);
assertEquals(4,elist2.size());
assertEquals("testtag.test01",elist2.get(i).tag);
}