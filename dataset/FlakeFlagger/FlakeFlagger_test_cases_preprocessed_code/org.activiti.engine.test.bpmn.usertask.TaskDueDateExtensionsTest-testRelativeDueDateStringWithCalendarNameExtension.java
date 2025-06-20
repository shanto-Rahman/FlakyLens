@Deployment public void testRelativeDueDateStringWithCalendarNameExtension() throws Exception {
assertNotNull(task.getDueDate());
assertEquals(task.getDueDate(),new Date(0));
}