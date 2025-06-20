@SuppressWarnings("serial") @Test public void testCreateActions() throws Exception {
assertEquals(1,response.getTasks().size());
assertEquals(1,storedTasks.size());
assertEquals(task.getTaskId(),hostRoleCommand.getTaskId());
assertEquals(actionRequest.getServiceName(),hostRoleCommand.getExecutionCommandWrapper().getExecutionCommand().getServiceName());
assertEquals(actionRequest.getClusterName(),hostRoleCommand.getExecutionCommandWrapper().getExecutionCommand().getClusterName());
assertEquals(actionRequest.getActionName(),hostRoleCommand.getExecutionCommandWrapper().getExecutionCommand().getRole().name());
assertEquals(Role.HDFS_CLIENT.name(),hostRoleCommand.getEvent().getEvent().getServiceComponentName());
assertEquals(actionRequest.getParameters(),hostRoleCommand.getExecutionCommandWrapper().getExecutionCommand().getRoleParams());
assertEquals(2,response.getTasks().size());
assertEquals(2,tasks.size());
}