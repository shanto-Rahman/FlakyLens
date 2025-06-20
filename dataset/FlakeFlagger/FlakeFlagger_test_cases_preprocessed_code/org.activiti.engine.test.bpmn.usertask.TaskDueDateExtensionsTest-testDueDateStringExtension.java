@Deployment public void testDueDateStringExtension() throws Exception {
assertNotNull(task.getDueDate());
assertEquals(date,task.getDueDate());
}