@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testQueryNullVariable() throws Exception {
assertNotNull(processInstances);
assertEquals(1,processInstances.size());
assertEquals(processInstance1.getId(),processInstances.get(0).getId());
assertEquals(1,runtimeService.createProcessInstanceQuery().variableValueNotEquals("nullVar",null).count());
assertEquals(1,runtimeService.createProcessInstanceQuery().variableValueNotEquals("nullVarLong",null).count());
assertEquals(1,runtimeService.createProcessInstanceQuery().variableValueNotEquals("nullVarDouble",null).count());
assertEquals(1,runtimeService.createProcessInstanceQuery().variableValueNotEquals("nullVarByte",null).count());
assertEquals(1,runtimeService.createProcessInstanceQuery().variableValueEquals(null).count());
fail("Exception expected");
fail("Exception expected");
fail("Exception expected");
fail("Exception expected");
fail("Exception expected");
assertEquals(0,runtimeService.createProcessInstanceQuery().variableValueEquals(null).count());
}