@Test public void doRegisterAndAvailable() throws Exception {
  registry.doRegister(serviceUrl);
  registry.doRegister(serviceUrl2);
  PortalRegistryService service1=PortalRegistryUtils.buildService(serviceUrl);
  Assert.assertTrue(client.isRegistered(service1));
  Assert.assertFalse(client.isWorking(service1));
  PortalRegistryService service2=PortalRegistryUtils.buildService(serviceUrl2);
  Assert.assertTrue(client.isRegistered(service2));
  Assert.assertFalse(client.isWorking(service2));
  registry.doAvailable(null);
  Thread.sleep(sleepTime);
  Assert.assertTrue(client.isWorking(service1));
  Assert.assertTrue(client.isWorking(service2));
  registry.doUnavailable(null);
  Thread.sleep(sleepTime);
  Assert.assertFalse(client.isWorking(service1));
  Assert.assertFalse(client.isWorking(service2));
  registry.doUnregister(serviceUrl);
  Assert.assertFalse(client.isRegistered(service1));
  Assert.assertTrue(client.isRegistered(service2));
  registry.doUnregister(serviceUrl2);
  Assert.assertFalse(client.isRegistered(service2));
}
