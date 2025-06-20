@Test public void testPersistActions(){
assertTrue(stage.getExecutionCommands(hostName).get(0).getExecutionCommand().getTaskId() > 0);
assertTrue(executionCommandDAO.findByPK(stage.getExecutionCommands(hostName).get(0).getExecutionCommand().getTaskId()) != null);
}