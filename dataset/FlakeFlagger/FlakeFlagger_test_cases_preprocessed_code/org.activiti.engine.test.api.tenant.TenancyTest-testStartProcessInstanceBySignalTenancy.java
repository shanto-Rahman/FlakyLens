public void testStartProcessInstanceBySignalTenancy(){
assertEquals(3,runtimeService.createProcessInstanceQuery().count());
assertEquals(3,runtimeService.createProcessInstanceQuery().processInstanceWithoutTenantId().count());
assertEquals(0,runtimeService.createProcessInstanceQuery().processInstanceTenantId(TEST_TENANT_ID).count());
assertEquals(6,runtimeService.createProcessInstanceQuery().count());
assertEquals(3,runtimeService.createProcessInstanceQuery().processInstanceWithoutTenantId().count());
assertEquals(3,runtimeService.createProcessInstanceQuery().processInstanceTenantId(TEST_TENANT_ID).count());
assertEquals(11,runtimeService.createProcessInstanceQuery().count());
assertEquals(7,runtimeService.createProcessInstanceQuery().processInstanceWithoutTenantId().count());
assertEquals(4,runtimeService.createProcessInstanceQuery().processInstanceTenantId(TEST_TENANT_ID).count());
assertEquals(14,runtimeService.createProcessInstanceQuery().count());
assertEquals(7,runtimeService.createProcessInstanceQuery().processInstanceWithoutTenantId().count());
assertEquals(7,runtimeService.createProcessInstanceQuery().processInstanceTenantId(TEST_TENANT_ID).count());
}