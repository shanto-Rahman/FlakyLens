@Test public void testCommandReport() throws AmbariException {
Assert.assertEquals(stageId,stage.getStageId());
assertEquals(215,am.getAction(requestId,stageId).getExitCode(hostname,"HBASE_MASTER"));
assertEquals(HostRoleStatus.COMPLETED,am.getAction(requestId,stageId).getHostRoleStatus(hostname,"HBASE_MASTER"));
assertEquals(HostRoleStatus.COMPLETED,s.getHostRoleStatus(hostname,"HBASE_MASTER"));
assertEquals(215,s.getExitCode(hostname,"HBASE_MASTER"));
}