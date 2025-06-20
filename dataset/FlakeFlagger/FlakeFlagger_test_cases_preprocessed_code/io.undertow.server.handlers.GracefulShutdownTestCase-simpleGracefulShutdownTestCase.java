@Test public void simpleGracefulShutdownTestCase() throws IOException, InterruptedException {
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
Assert.assertFalse(shutdown.awaitShutdown(10));//RW
latch.countDown();
Assert.assertTrue(shutdown.awaitShutdown(10000));//RW
client.getConnectionManager().shutdown();//RW
}