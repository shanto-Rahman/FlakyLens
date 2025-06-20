@Deployment public void testReleaseTask() throws Exception {
assertNotNull(task);
assertNull(task);
assertNotNull(task);
assertNull(task.getAssignee());
}