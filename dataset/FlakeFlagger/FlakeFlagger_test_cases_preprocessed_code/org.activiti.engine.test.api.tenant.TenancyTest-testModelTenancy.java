public void testModelTenancy(){
assertEquals(nrOfModelsWithoutTenant + nrOfModelsWithTenant,repositoryService.createModelQuery().list().size());
assertEquals(nrOfModelsWithoutTenant,repositoryService.createModelQuery().modelWithoutTenantId().list().size());
assertEquals(nrOfModelsWithTenant,repositoryService.createModelQuery().modelTenantId(TEST_TENANT_ID).list().size());
assertEquals(nrOfModelsWithTenant,repositoryService.createModelQuery().modelTenantIdLike("my%").list().size());
assertEquals(0,repositoryService.createModelQuery().modelTenantId("a%").list().size());
}