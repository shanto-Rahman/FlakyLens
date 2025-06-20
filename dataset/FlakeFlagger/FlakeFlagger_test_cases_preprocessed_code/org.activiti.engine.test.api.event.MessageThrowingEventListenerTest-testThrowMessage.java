@Deployment public void testThrowMessage() throws Exception {
assertNotNull(processInstance);
assertNotNull(task);
assertNotNull(task);
assertEquals("kermit",task.getAssignee());
assertNotNull(boundaryTask);
}