@Deployment public void testOnCompleteCustomPropertiesResolver(){
assertEquals(1,currentTasks.size());
assertEquals("usertask1",currentTasks.get(0).getTaskId());
assertEquals("User Task 1",currentTasks.get(0).getTaskName());
assertEquals(1,currentTasks.get(0).getCustomPropertiesMap().size());
assertEquals("usertask1",currentTasks.get(0).getCustomPropertiesMap().get("customProp1"));
}