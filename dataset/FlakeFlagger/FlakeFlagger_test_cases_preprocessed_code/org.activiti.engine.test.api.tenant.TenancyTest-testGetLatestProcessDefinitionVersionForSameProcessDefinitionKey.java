public void testGetLatestProcessDefinitionVersionForSameProcessDefinitionKey(){
assertEquals(4,processDefinition.getVersion());
assertEquals(2,processDefinition.getVersion());
assertEquals(3,processDefinition.getVersion());
assertEquals(3,processDefinitions.size());
if (p.getTenantId() == null || p.getTenantId().equals(ProcessEngineConfiguration.NO_TENANT_ID)) {
if (p.getTenantId().equals(tenant1)) {
if (p.getTenantId().equals(tenant2)) {
}
}
}
assertEquals(1,tenant1Count);
assertEquals(1,tenant2Count);
assertEquals(1,noTenantCount);
}