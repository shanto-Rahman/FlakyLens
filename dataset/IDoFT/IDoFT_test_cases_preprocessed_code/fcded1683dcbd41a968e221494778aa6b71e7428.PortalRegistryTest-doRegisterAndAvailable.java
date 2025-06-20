@Test public void doRegisterAndAvailable() throws Exception {
Assert.assertTrue(client.isRegistered(service1));
Assert.assertFalse(client.isWorking(service1));
Assert.assertTrue(client.isRegistered(service2));
Assert.assertFalse(client.isWorking(service2));
Thread.sleep(sleepTime);
Assert.assertTrue(client.isWorking(service1));
Assert.assertTrue(client.isWorking(service2));
Thread.sleep(sleepTime);
Assert.assertFalse(client.isWorking(service1));
Assert.assertFalse(client.isWorking(service2));
Assert.assertFalse(client.isRegistered(service1));
Assert.assertTrue(client.isRegistered(service2));
Assert.assertFalse(client.isRegistered(service2));
}