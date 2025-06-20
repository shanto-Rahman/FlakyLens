@Test public void doRegisterAndAvailable() throws Exception {
Assert.assertTrue(client.isRegistered(serviceid));
Assert.assertFalse(client.isWorking(serviceid));
Assert.assertTrue(client.isRegistered(serviceid2));
Assert.assertFalse(client.isWorking(serviceid2));
Thread.sleep(sleepTime);
Assert.assertTrue(client.isWorking(serviceid));
Assert.assertTrue(client.isWorking(serviceid2));
Thread.sleep(sleepTime);
Assert.assertFalse(client.isWorking(serviceid));
Assert.assertFalse(client.isWorking(serviceid2));
Assert.assertFalse(client.isRegistered(serviceid));
Assert.assertTrue(client.isRegistered(serviceid2));
Assert.assertFalse(client.isRegistered(serviceid2));
}