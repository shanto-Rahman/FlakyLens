@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testQueryLikeIgnoreCase(){
assertNotNull(execution);
assertEquals(processInstance1.getId(),execution.getId());
assertNotNull(execution);
assertEquals(processInstance1.getId(),execution.getId());
assertNotNull(execution);
assertEquals(processInstance1.getId(),execution.getId());
assertNotNull(execution);
assertEquals(processInstance1.getId(),execution.getId());
fail("Exception expected");
assertEquals("value is null",ae.getMessage());
fail("Exception expected");
assertEquals("name is null",ae.getMessage());
}