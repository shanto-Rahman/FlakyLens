public void testProcessInstanceTenancy(){
assertEquals(TEST_TENANT_ID,runtimeService.createProcessInstanceQuery().processDefinitionId(processDefinitionId).list().get(0).getTenantId());
assertEquals(nrOfProcessInstancesNoTenant + nrOfProcessInstancesWithTenant,runtimeService.createProcessInstanceQuery().list().size());
assertEquals(nrOfProcessInstancesNoTenant,runtimeService.createProcessInstanceQuery().processInstanceWithoutTenantId().list().size());
assertEquals(nrOfProcessInstancesWithTenant,runtimeService.createProcessInstanceQuery().processInstanceTenantId(TEST_TENANT_ID).list().size());
assertEquals(nrOfProcessInstancesWithTenant,runtimeService.createProcessInstanceQuery().processInstanceTenantIdLike("%enan%").list().size());
}