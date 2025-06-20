@Deployment public void testEndTimeOnMiSubprocess(){
if (!processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
}
assertEquals(2,tasks.size());
assertEquals("User Task 1",tasks.get(0).getName());
assertEquals("User Task 1",tasks.get(1).getName());
assertEquals(2,historicActivityInstances.size());
assertNotNull(historicActivityInstance.getStartTime());
assertNull(historicActivityInstance.getEndTime());
assertEquals(2,historicActivityInstances.size());
assertNull(historicActivityInstance.getEndTime());
assertEquals(2,historicActivityInstances.size());
assertNull(historicActivityInstance.getEndTime());
assertEquals(2,tasks.size());
assertEquals(2,historicActivityInstances.size());
assertNull(historicActivityInstance.getEndTime());
assertEquals(2,tasks.size());
assertEquals(2,historicActivityInstances.size());
assertNotNull(historicActivityInstance.getEndTime());
}