@Test public void testHostHeartbeatFlow() throws Exception {
Assert.assertEquals(counter,host.getLastHeartbeatTime());
Assert.assertEquals(counter,host.getLastHeartbeatTime());
Assert.assertEquals(HealthStatus.HEALTHY,host.getHealthStatus().getHealthStatus());
Assert.assertEquals(counter,host.getLastHeartbeatTime());
Assert.assertEquals(HealthStatus.UNHEALTHY,host.getHealthStatus().getHealthStatus());
Assert.assertEquals(counter,host.getLastHeartbeatTime());
Assert.assertEquals(HealthStatus.UNHEALTHY,host.getHealthStatus().getHealthStatus());
Assert.assertEquals(counter,host.getLastHeartbeatTime());
Assert.assertEquals(HealthStatus.HEALTHY,host.getHealthStatus().getHealthStatus());
Assert.assertEquals(counter,host.getLastHeartbeatTime());
Assert.assertEquals(HealthStatus.UNKNOWN,host.getHealthStatus().getHealthStatus());
Assert.assertEquals(counter,host.getLastHeartbeatTime());
Assert.assertEquals(HealthStatus.UNKNOWN,host.getHealthStatus().getHealthStatus());
fail("Invalid event should have triggered an exception");
fail("Invalid event should have triggered an exception");
}