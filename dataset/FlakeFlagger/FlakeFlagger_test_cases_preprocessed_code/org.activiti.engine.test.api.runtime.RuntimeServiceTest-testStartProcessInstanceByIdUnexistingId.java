public void testStartProcessInstanceByIdUnexistingId(){
fail("ActivitiException expected");
assertEquals(ProcessDefinition.class,ae.getObjectClass());
}