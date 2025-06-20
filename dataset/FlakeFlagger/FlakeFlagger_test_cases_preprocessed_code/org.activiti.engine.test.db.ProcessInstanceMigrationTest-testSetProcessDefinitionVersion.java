@Deployment public void testSetProcessDefinitionVersion(){
assertNotNull(execution);
assertEquals(2,repositoryService.createProcessDefinitionQuery().count());
assertEquals(newProcessDefinition.getId(),pi.getProcessDefinitionId());
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
assertEquals(newProcessDefinition.getId(),historicPI.getProcessDefinitionId());
assertEquals(1,historicActivities.size());
assertEquals(newProcessDefinition.getId(),historicActivities.get(0).getProcessDefinitionId());
}
}