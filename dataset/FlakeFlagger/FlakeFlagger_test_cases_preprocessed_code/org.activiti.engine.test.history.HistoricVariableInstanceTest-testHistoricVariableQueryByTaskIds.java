public void testHistoricVariableQueryByTaskIds(){
assertEquals(2,historyService.createHistoricVariableInstanceQuery().taskIds(taskIds).count());
assertEquals(2,historicVariableInstances.size());
assertEquals("taskVar1",historicVariableInstances.get(0).getVariableName());
assertEquals("hello1",historicVariableInstances.get(0).getValue());
assertEquals("taskVar2",historicVariableInstances.get(1).getVariableName());
assertEquals("hello2",historicVariableInstances.get(1).getValue());
assertEquals(1,historyService.createHistoricVariableInstanceQuery().taskIds(taskIds).count());
assertEquals(1,historicVariableInstances.size());
assertEquals("taskVar1",historicVariableInstances.get(0).getVariableName());
assertEquals("hello1",historicVariableInstances.get(0).getValue());
}