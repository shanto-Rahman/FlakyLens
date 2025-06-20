@Deployment public void testHistoricTaskInstanceVariableUpdates(){
assertEquals(1,historyService.createHistoricTaskInstanceQuery().count());
assertEquals(2,historicTaskVariableUpdates.size());
assertEquals(0,historicTaskVariableUpdates.size());
}