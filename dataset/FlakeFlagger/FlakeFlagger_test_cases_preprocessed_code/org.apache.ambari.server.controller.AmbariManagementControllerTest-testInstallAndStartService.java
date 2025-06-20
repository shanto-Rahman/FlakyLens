@Test public void testInstallAndStartService() throws Exception {
Assert.assertEquals(State.INSTALLED,clusters.getCluster(clusterName).getService(serviceName).getDesiredState());
Assert.assertEquals(State.INSTALLED,sc.getDesiredState());
Assert.assertEquals(State.INSTALLED,sch.getDesiredState());
Assert.assertEquals(State.INIT,sch.getState());
Assert.assertEquals(5,taskStatuses.size());
Assert.assertEquals(RoleCommand.INSTALL.toString(),taskStatus.getCommand());
Assert.assertEquals(HostRoleStatus.PENDING.toString(),taskStatus.getStatus());
if (taskStatus.getHostName().equals("h1")) {
if (Role.NAMENODE.toString().equals(taskStatus.getRole())) {
if (Role.DATANODE.toString().equals(taskStatus.getRole())) {
if (Role.HDFS_CLIENT.toString().equals(taskStatus.getRole())) {
fail("Found invalid role for host h1");
}
}
}
if (taskStatus.getHostName().equals("h2")) {
if (Role.DATANODE.toString().equals(taskStatus.getRole())) {
if (Role.HDFS_CLIENT.toString().equals(taskStatus.getRole())) {
fail("Found invalid role for host h2");
}
}
fail("Found invalid host in task list");
}
}
Assert.assertTrue(foundH1DN && foundH1NN && foundH2DN&& foundH1CLT&& foundH2CLT);
Assert.assertEquals(1,stages.size());
Assert.assertFalse(ecw.getExecutionCommand().getHostLevelParams().get("repo_info").isEmpty());
Assert.assertEquals(1,statusResponses.size());
Assert.assertNotNull(statusResponse);
Assert.assertEquals(trackAction.getRequestId(),statusResponse.getRequestId());
Assert.assertEquals(5,statusResponse.getTasks().size());
Assert.assertEquals(5,taskResponses.size());
Assert.assertEquals(2,taskResponses.size());
Assert.assertEquals(State.STARTED,clusters.getCluster(clusterName).getService(serviceName).getDesiredState());
if (sc.getName().equals("HDFS_CLIENT")) {
Assert.assertEquals(State.INSTALLED,sc.getDesiredState());
Assert.assertEquals(State.STARTED,sc.getDesiredState());
}
if (sch.getServiceComponentName().equals("HDFS_CLIENT")) {
Assert.assertEquals(State.INSTALLED,sch.getDesiredState());
Assert.assertEquals(State.STARTED,sch.getDesiredState());
}
Assert.assertEquals(2,stages.size());
Assert.assertEquals(2,statusResponses.size());
if (sc.isClientComponent()) {
}
Assert.assertEquals(State.INSTALLED,clusters.getCluster(clusterName).getService(serviceName).getDesiredState());
Assert.assertEquals(State.INSTALLED,sc.getDesiredState());
Assert.assertEquals(State.INSTALLED,sch.getDesiredState());
Assert.assertEquals(1,stages.size());
}