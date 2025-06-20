@Deployment public void testCustomPropertiesMapDelegateExpression(){
assertEquals("task3",listener.getCurrentTasks().get(0).getTaskId());
assertEquals("task3",listener.getCurrentTasks().get(0).getCustomPropertiesMap().get("customProp1"));
assertEquals("task4",listener.getCurrentTasks().get(1).getTaskId());
assertEquals("task4",listener.getCurrentTasks().get(1).getCustomPropertiesMap().get("customProp1"));
}