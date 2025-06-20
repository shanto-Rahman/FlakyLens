@Deployment public void testQueryJPAVariable(){
variables.put("entityToQuery",entityToQuery);//RW
ProcessInstance result=runtimeService.createProcessInstanceQuery().variableValueEquals("entityToQuery",entityToQuery).singleResult();//RW
assertNotNull(result);
assertEquals(result.getId(),processInstance.getId());
assertNull(result);
runtimeService.createProcessInstanceQuery().variableValueNotEquals("entityToQuery",entityToQuery).singleResult();//RW
fail("Exception expected");
runtimeService.createProcessInstanceQuery().variableValueGreaterThan("entityToQuery",entityToQuery).singleResult();//RW
fail("Exception expected");
runtimeService.createProcessInstanceQuery().variableValueGreaterThanOrEqual("entityToQuery",entityToQuery).singleResult();//RW
fail("Exception expected");
runtimeService.createProcessInstanceQuery().variableValueLessThan("entityToQuery",entityToQuery).singleResult();//RW
fail("Exception expected");
runtimeService.createProcessInstanceQuery().variableValueLessThanOrEqual("entityToQuery",entityToQuery).singleResult();//RW
fail("Exception expected");
}