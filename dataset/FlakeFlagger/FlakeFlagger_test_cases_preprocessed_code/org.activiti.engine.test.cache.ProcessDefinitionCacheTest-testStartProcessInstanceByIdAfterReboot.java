public void testStartProcessInstanceByIdAfterReboot(){
assertEquals(1,processDefinitions.size());
assertNotNull(processInstance);
assertNotNull(processEngine.getRuntimeService());
assertNotNull(processInstance);
assertNull(processInstance);
assertNotNull(processInstance);
}