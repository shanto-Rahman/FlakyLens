public void testSignalFromProcessTenancy(){
assertEquals(3,taskService.createTaskQuery().taskName("My task").taskTenantId(TEST_TENANT_ID).count());
assertEquals(2,taskService.createTaskQuery().taskName("My task").taskWithoutTenantId().count());
assertEquals(0,taskService.createTaskQuery().taskName("Task after signal").taskTenantId(TEST_TENANT_ID).count());
assertEquals(2,taskService.createTaskQuery().taskName("Task after signal").taskWithoutTenantId().count());
assertEquals(3,taskService.createTaskQuery().taskName("Task after signal").taskTenantId(TEST_TENANT_ID).count());
assertEquals(2,taskService.createTaskQuery().taskName("Task after signal").taskWithoutTenantId().count());
}