@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testQueryEqualsIgnoreCase(){
assertNotNull(instance);
assertEquals(processInstance1.getId(),instance.getId());
assertNotNull(instance);
assertEquals(processInstance1.getId(),instance.getId());
assertNotNull(instance);
assertEquals(processInstance1.getId(),instance.getId());
assertNotNull(instance);
assertEquals(processInstance1.getId(),instance.getId());
fail("Exception expected");
assertEquals("value is null",ae.getMessage());
fail("Exception expected");
assertEquals("name is null",ae.getMessage());
assertNotNull(instance);
assertNull(instance);
assertNotNull(instance);
fail("Exception expected");
assertEquals("value is null",ae.getMessage());
fail("Exception expected");
assertEquals("name is null",ae.getMessage());
}