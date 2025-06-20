public void testGetVariablesWithCollectionThroughRuntimeService(){
assertEquals(4,vars.size());
assertEquals(100,vars.get("intVar1"));
assertEquals(300,vars.get("intVar3"));
assertEquals(500,vars.get("intVar5"));
assertEquals(900,vars.get("intVar9"));
assertEquals(4,runtimeService.getVariablesLocal(processInstanceId,Arrays.asList("intVar1","intVar3","intVar5","intVar9")).size());
assertFalse(processInstanceId.equals(executionId));
assertEquals(0,runtimeService.getVariablesLocal(executionId,Arrays.asList("intVar1","intVar3","intVar5","intVar9")).size());
}