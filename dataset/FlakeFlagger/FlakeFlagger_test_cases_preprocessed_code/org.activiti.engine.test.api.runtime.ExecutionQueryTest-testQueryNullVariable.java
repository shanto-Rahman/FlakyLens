@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testQueryNullVariable() throws Exception {
assertNotNull(executions);
assertEquals(1,executions.size());
assertEquals(processInstance1.getId(),executions.get(0).getId());
assertEquals(1,runtimeService.createExecutionQuery().variableValueNotEquals("nullVar",null).count());
assertEquals(1,runtimeService.createExecutionQuery().variableValueNotEquals("nullVarLong",null).count());
assertEquals(1,runtimeService.createExecutionQuery().variableValueNotEquals("nullVarDouble",null).count());
assertEquals(1,runtimeService.createExecutionQuery().variableValueNotEquals("nullVarByte",null).count());
assertNotNull(execution);
assertEquals(processInstance1.getId(),execution.getId());
fail("Exception expected");
fail("Exception expected");
fail("Exception expected");
fail("Exception expected");
fail("Exception expected");
assertNull(execution);
}