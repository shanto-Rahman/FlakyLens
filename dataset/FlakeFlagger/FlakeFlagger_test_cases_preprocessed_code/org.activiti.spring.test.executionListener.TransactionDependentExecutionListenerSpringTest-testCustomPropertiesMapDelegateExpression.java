@Deployment public void testCustomPropertiesMapDelegateExpression(){
assertEquals("task3",listener.getCurrentActivities().get(0).getActivityId());
assertEquals("task3",listener.getCurrentActivities().get(0).getCustomPropertiesMap().get("customProp1"));
assertEquals("task4",listener.getCurrentActivities().get(1).getActivityId());
assertEquals("task4",listener.getCurrentActivities().get(1).getCustomPropertiesMap().get("customProp1"));
}