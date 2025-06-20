@Test public void gracefulShutdownListenerTestCase() throws IOException, InterruptedException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
shutdown.shutdown();//RW
Assert.assertEquals(503,result.getStatusLine().getStatusCode());
shutdown.start();//RW
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
latch2.set(latch);
latch1.set(new CountDownLatch(1));
t.start();
latch1.get().await();
shutdown.shutdown();//RW
shutdown.addShutdownListener(listener);//RW
Assert.assertFalse(listener.invoked);
latch.countDown();
Thread.sleep(10);
Assert.assertTrue(listener.invoked);
client.getConnectionManager().shutdown();//RW
}