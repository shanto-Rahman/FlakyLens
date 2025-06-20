@Test public void testClientServiceSmokeTests() throws AmbariException {
Assert.assertEquals(State.INSTALLED,clusters.getCluster(clusterName).getService(serviceName).getDesiredState());
Assert.assertEquals(State.INSTALLED,sc.getDesiredState());
Assert.assertEquals(State.INSTALLED,sch.getDesiredState());
Assert.assertEquals(State.INIT,sch.getState());
Assert.assertEquals(2,taskStatuses.size());
Assert.assertEquals(1,stages.size());
Assert.assertNotNull(trackAction);
Assert.assertEquals(State.INSTALLED,clusters.getCluster(clusterName).getService(serviceName).getDesiredState());
Assert.assertEquals(State.INSTALLED,sc.getDesiredState());
Assert.assertEquals(State.INSTALLED,sch.getDesiredState());
Assert.assertEquals(State.INSTALLED,sch.getState());
Assert.assertEquals(1,stages.size());
Assert.assertEquals(1,taskStatuses.size());
Assert.assertEquals(Role.PIG_SERVICE_CHECK.toString(),taskStatuses.get(0).getRole());
}