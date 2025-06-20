@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testBooleanVariable() throws Exception {
assertNotNull(instances);
assertEquals(1,instances.size());
assertEquals(processInstance1.getId(),instances.get(0).getId());
assertNotNull(instances);
assertEquals(1,instances.size());
assertEquals(processInstance2.getId(),instances.get(0).getId());
assertNotNull(instances);
assertEquals(1,instances.size());
assertEquals(processInstance2.getId(),instances.get(0).getId());
assertNotNull(instances);
assertEquals(1,instances.size());
assertEquals(processInstance1.getId(),instances.get(0).getId());
assertNotNull(instances);
assertEquals(1,instances.size());
assertEquals(processInstance1.getId(),instances.get(0).getId());
fail("Exception expected");
fail("Exception expected");
fail("Exception expected");
fail("Exception expected");
assertNotNull(instances);
assertEquals(0,instances.size());
}