public void testDeleteProcessInstanceUnexistingId(){
fail("ActivitiException expected");
assertEquals(ProcessInstance.class,ae.getObjectClass());
}