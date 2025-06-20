@Deployment public void testMultiInstanceTask(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
if ("task".equals(historicActivityInstance.getActivityId())) {
if ("theStart".equals(historicActivityInstance.getActivityId())) {
if ("theEnd".equals(historicActivityInstance.getActivityId())) {
Assert.fail("Unexpected activity found " + historicActivityInstance.getActivityId());
}
}
}
assertEquals(1,startCount);
assertEquals(3,taskCount);
assertEquals(1,endCount);
}
}