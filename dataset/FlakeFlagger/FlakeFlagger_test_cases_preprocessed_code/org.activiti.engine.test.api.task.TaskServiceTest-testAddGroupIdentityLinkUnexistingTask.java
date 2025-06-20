public void testAddGroupIdentityLinkUnexistingTask(){
fail("ActivitiException expected");
assertEquals(Task.class,ae.getObjectClass());
}