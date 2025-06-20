public void testCallActivityWithTenant(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.ACTIVITY)) {
Assert.assertNotNull(processInstance);
Assert.assertEquals(1,historyService.createHistoricProcessInstanceQuery().processDefinitionKey("process2").processInstanceTenantId(tenantId).count());
Assert.assertEquals(1,historyService.createHistoricProcessInstanceQuery().processDefinitionKey("process2").count());
Assert.fail();
}
}