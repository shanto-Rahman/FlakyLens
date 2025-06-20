@Deployment public void testThrowMessageDefinedInProcessDefinition() throws Exception {
assertNotNull(processInstance);
assertNotNull(task);
assertNotNull(task);
assertEquals("kermit",task.getAssignee());
assertNotNull(boundaryTask);
}