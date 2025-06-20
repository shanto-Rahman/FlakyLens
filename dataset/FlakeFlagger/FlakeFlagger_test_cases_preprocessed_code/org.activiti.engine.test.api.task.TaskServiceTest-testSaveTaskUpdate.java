public void testSaveTaskUpdate() throws Exception {
assertEquals("description",task.getDescription());
assertEquals("taskname",task.getName());
assertEquals("taskassignee",task.getAssignee());
assertEquals("taskowner",task.getOwner());
assertEquals(dueDate,task.getDueDate());
assertEquals(0,task.getPriority());
assertEquals("updatedtaskname",task.getName());
assertEquals("updateddescription",task.getDescription());
assertEquals("updatedassignee",task.getAssignee());
assertEquals("updatedowner",task.getOwner());
assertEquals(dueDate,task.getDueDate());
assertEquals(1,task.getPriority());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals("updatedtaskname",historicTaskInstance.getName());
assertEquals("updateddescription",historicTaskInstance.getDescription());
assertEquals("updatedassignee",historicTaskInstance.getAssignee());
assertEquals("updatedowner",historicTaskInstance.getOwner());
assertEquals(dueDate,historicTaskInstance.getDueDate());
assertEquals(1,historicTaskInstance.getPriority());
}
}