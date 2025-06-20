@Deployment(resources="org/activiti/engine/test/history/HistoricVariableInstanceTest.testSimple.bpmn20.xml") public void testNativeHistoricVariableInstanceQuery(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.FULL)) {
assertEquals("ACT_HI_VARINST",managementService.getTableName(HistoricVariableInstance.class));
assertEquals("ACT_HI_VARINST",managementService.getTableName(HistoricVariableInstanceEntity.class));
assertNotNull(processInstance);
assertEquals(3,historyService.createNativeHistoricVariableInstanceQuery().sql(baseQuerySql).list().size());
assertEquals("test123",historyService.createNativeHistoricVariableInstanceQuery().sql(sqlWithConditions).parameter("name","myVar").singleResult().getValue());
assertEquals(2,historyService.createNativeHistoricVariableInstanceQuery().sql(sqlWithConditions).parameter("name","var%").list().size());
assertEquals(3,historyService.createNativeHistoricVariableInstanceQuery().sql(baseQuerySql).listPage(0,3).size());
assertEquals(2,historyService.createNativeHistoricVariableInstanceQuery().sql(baseQuerySql).listPage(1,3).size());
assertEquals(2,historyService.createNativeHistoricVariableInstanceQuery().sql(sqlWithConditions).parameter("name","var%").listPage(0,2).size());
}
}