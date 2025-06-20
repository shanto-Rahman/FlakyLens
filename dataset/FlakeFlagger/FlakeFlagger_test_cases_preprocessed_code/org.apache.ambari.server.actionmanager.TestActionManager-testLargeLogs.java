@Test public void testLargeLogs(){
Assert.assertEquals(stageId,stage.getStageId());
assertEquals(215,am.getAction(requestId,stageId).getExitCode(hostname,"HBASE_MASTER"));
assertEquals(HostRoleStatus.COMPLETED,am.getAction(requestId,stageId).getHostRoleStatus(hostname,"HBASE_MASTER"));
assertEquals(errLog.length(),am.getAction(requestId,stageId).getHostRoleCommand(hostname,"HBASE_MASTER").getStderr().length());
assertEquals(outLog.length(),am.getAction(requestId,stageId).getHostRoleCommand(hostname,"HBASE_MASTER").getStdout().length());
}