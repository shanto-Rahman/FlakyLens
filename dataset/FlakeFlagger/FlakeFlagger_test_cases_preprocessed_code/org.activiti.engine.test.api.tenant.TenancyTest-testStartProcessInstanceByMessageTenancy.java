public void testStartProcessInstanceByMessageTenancy(){
assertEquals(2,repositoryService.createProcessDefinitionQuery().messageEventSubscriptionName("My message").count());
assertEquals(1,repositoryService.createProcessDefinitionQuery().messageEventSubscriptionName("My message").processDefinitionWithoutTenantId().count());
assertEquals(1,repositoryService.createProcessDefinitionQuery().messageEventSubscriptionName("My message").processDefinitionTenantId(TEST_TENANT_ID).count());
assertEquals(2,taskService.createTaskQuery().taskName("My task").count());
assertEquals(2,taskService.createTaskQuery().taskName("My task").taskWithoutTenantId().count());
assertEquals(0,taskService.createTaskQuery().taskName("My task").taskTenantId(TEST_TENANT_ID).count());
assertEquals(5,taskService.createTaskQuery().taskName("My task").count());
assertEquals(2,taskService.createTaskQuery().taskName("My task").taskWithoutTenantId().count());
assertEquals(3,taskService.createTaskQuery().taskName("My task").taskTenantId(TEST_TENANT_ID).count());
}