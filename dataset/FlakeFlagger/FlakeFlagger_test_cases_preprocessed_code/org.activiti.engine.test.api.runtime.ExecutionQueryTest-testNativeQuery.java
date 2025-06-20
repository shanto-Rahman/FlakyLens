public void testNativeQuery(){
assertEquals("ACT_RU_EXECUTION",managementService.getTableName(Execution.class));
assertEquals(executionCount,runtimeService.createNativeExecutionQuery().sql("SELECT * FROM " + managementService.getTableName(Execution.class)).list().size());
assertEquals(executionCount,runtimeService.createNativeExecutionQuery().sql("SELECT count(*) FROM " + managementService.getTableName(Execution.class)).count());
}