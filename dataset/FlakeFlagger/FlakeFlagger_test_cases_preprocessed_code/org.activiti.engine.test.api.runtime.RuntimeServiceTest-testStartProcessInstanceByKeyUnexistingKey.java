public void testStartProcessInstanceByKeyUnexistingKey(){
fail("ActivitiException expected");
assertEquals(ProcessDefinition.class,ae.getObjectClass());
}