public void testHistoryTenancy(){
if (processEngineConfiguration.getHistoryLevel().isAtLeast(HistoryLevel.AUDIT)) {
assertEquals(TEST_TENANT_ID,historyService.createHistoricProcessInstanceQuery().processDefinitionId(processDefinitionIdWithTenant).list().get(0).getTenantId());
assertEquals("",historyService.createHistoricProcessInstanceQuery().processDefinitionId(processDefinitionIdNoTenant).list().get(0).getTenantId());
assertEquals(nrOfProcessInstancesWithTenant + nrOfProcessInstancesNoTenant,historyService.createHistoricProcessInstanceQuery().list().size());
assertEquals(nrOfProcessInstancesWithTenant,historyService.createHistoricProcessInstanceQuery().processInstanceTenantId(TEST_TENANT_ID).list().size());
assertEquals(nrOfProcessInstancesWithTenant,historyService.createHistoricProcessInstanceQuery().processInstanceTenantIdLike("%e%").list().size());
assertEquals(nrOfProcessInstancesNoTenant,historyService.createHistoricProcessInstanceQuery().processInstanceWithoutTenantId().list().size());
assertEquals(TEST_TENANT_ID,historyService.createHistoricTaskInstanceQuery().processDefinitionId(processDefinitionIdWithTenant).list().get(0).getTenantId());
assertEquals("",historyService.createHistoricTaskInstanceQuery().processDefinitionId(processDefinitionIdNoTenant).list().get(0).getTenantId());
assertEquals(nrOfProcessInstancesWithTenant + nrOfProcessInstancesNoTenant,historyService.createHistoricTaskInstanceQuery().list().size());
assertEquals(nrOfProcessInstancesWithTenant,historyService.createHistoricTaskInstanceQuery().taskTenantId(TEST_TENANT_ID).list().size());
assertEquals(nrOfProcessInstancesWithTenant,historyService.createHistoricTaskInstanceQuery().taskTenantIdLike("my%").list().size());
assertEquals(nrOfProcessInstancesNoTenant,historyService.createHistoricTaskInstanceQuery().taskWithoutTenantId().list().size());
assertEquals(TEST_TENANT_ID,historicActivityInstance.getTenantId());
assertEquals("",historyService.createHistoricActivityInstanceQuery().processDefinitionId(processDefinitionIdNoTenant).list().get(0).getTenantId());
assertEquals(3 * (nrOfProcessInstancesWithTenant + nrOfProcessInstancesNoTenant),historyService.createHistoricActivityInstanceQuery().list().size());
assertEquals(3 * nrOfProcessInstancesWithTenant,historyService.createHistoricActivityInstanceQuery().activityTenantId(TEST_TENANT_ID).list().size());
assertEquals(3 * nrOfProcessInstancesWithTenant,historyService.createHistoricActivityInstanceQuery().activityTenantIdLike("my%").list().size());
assertEquals(3 * nrOfProcessInstancesNoTenant,historyService.createHistoricActivityInstanceQuery().activityWithoutTenantId().list().size());
}
}