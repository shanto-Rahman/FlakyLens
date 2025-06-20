@Test public void testActionResponse(){
Assert.assertEquals(stageId,stage.getStageId());
assertEquals(215,am.getAction(requestId,stageId).getExitCode(hostname,"HBASE_MASTER"));
assertEquals(HostRoleStatus.COMPLETED,am.getAction(requestId,stageId).getHostRoleStatus(hostname,"HBASE_MASTER"));
assertEquals("ERROR",am.getAction(requestId,stageId).getHostRoleCommand(hostname,"HBASE_MASTER").getStderr());
assertEquals("OUTPUT",am.getAction(requestId,stageId).getHostRoleCommand(hostname,"HBASE_MASTER").getStdout());
}