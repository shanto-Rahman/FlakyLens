public void testPerformDatabaseSchemaOperationCreate() throws Exception {
assertEquals(1,engine1.getRepositoryService().createDeploymentQuery().count());
assertEquals(0,engine2.getRepositoryService().createDeploymentQuery().count());
}