@Test public void testGetATestStage(){
assertEquals("cluster1",wrapper.getExecutionCommand().getClusterName());
assertEquals(StageUtils.getActionId(1,2),wrapper.getExecutionCommand().getCommandId());
assertEquals(hostname,wrapper.getExecutionCommand().getHostname());
}