@Deployment public void testRelativeDueDateStringExtension() throws Exception {
assertNotNull(task.getDueDate());
assertEquals(2,period.getDays());
assertEquals(5,period.getHours());
assertEquals(40,period.getMinutes());
}