@Deployment public void testDueDateExtension() throws Exception {
assertNotNull(task.getDueDate());
assertEquals(date,task.getDueDate());
}