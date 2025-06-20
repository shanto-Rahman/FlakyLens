public void testSignalAsyncThroughApiTenancy(){
assertEquals(4,taskService.createTaskQuery().taskName("My task").taskTenantId(TEST_TENANT_ID).count());
assertEquals(5,taskService.createTaskQuery().taskName("My task").taskWithoutTenantId().count());
assertEquals(0,taskService.createTaskQuery().taskName("Task after signal").taskTenantId(TEST_TENANT_ID).count());
assertEquals(0,taskService.createTaskQuery().taskName("Task after signal").taskWithoutTenantId().count());
assertEquals(4,taskService.createTaskQuery().taskName("Task after signal").taskTenantId(TEST_TENANT_ID).count());
assertEquals(0,taskService.createTaskQuery().taskName("Task after signal").taskWithoutTenantId().count());
assertEquals(4,taskService.createTaskQuery().taskName("Task after signal").taskTenantId(TEST_TENANT_ID).count());
assertEquals(0,taskService.createTaskQuery().taskName("Task after signal").taskWithoutTenantId().count());
assertEquals(4,taskService.createTaskQuery().taskName("Task after signal").taskTenantId(TEST_TENANT_ID).count());
assertEquals(5,taskService.createTaskQuery().taskName("Task after signal").taskWithoutTenantId().count());
}