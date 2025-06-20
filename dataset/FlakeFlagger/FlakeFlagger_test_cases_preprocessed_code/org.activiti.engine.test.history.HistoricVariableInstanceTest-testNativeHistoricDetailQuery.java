@Deployment(resources="org/activiti/engine/test/history/HistoricVariableInstanceTest.testSimple.bpmn20.xml") public void testNativeHistoricDetailQuery(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.FULL)) {
assertEquals("ACT_HI_DETAIL",managementService.getTableName(HistoricDetail.class));
assertEquals("ACT_HI_DETAIL",managementService.getTableName(HistoricVariableUpdate.class));
assertNotNull(processInstance);
assertEquals(3,historyService.createNativeHistoricDetailQuery().sql(baseQuerySql).list().size());
assertNotNull(historyService.createNativeHistoricDetailQuery().sql(sqlWithConditions).parameter("name","myVar").parameter("type","VariableUpdate").singleResult());
assertEquals(2,historyService.createNativeHistoricDetailQuery().sql(sqlWithConditions).parameter("name","var%").list().size());
assertEquals(3,historyService.createNativeHistoricDetailQuery().sql(baseQuerySql).listPage(0,3).size());
assertEquals(2,historyService.createNativeHistoricDetailQuery().sql(baseQuerySql).listPage(1,3).size());
}
}