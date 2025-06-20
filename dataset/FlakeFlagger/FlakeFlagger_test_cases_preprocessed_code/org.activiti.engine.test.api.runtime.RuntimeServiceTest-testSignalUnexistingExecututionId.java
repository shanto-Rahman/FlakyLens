public void testSignalUnexistingExecututionId(){
fail("ActivitiException expected");
assertEquals(Execution.class,ae.getObjectClass());
}