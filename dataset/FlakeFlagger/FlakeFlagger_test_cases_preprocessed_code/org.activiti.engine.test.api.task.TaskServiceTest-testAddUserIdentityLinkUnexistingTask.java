public void testAddUserIdentityLinkUnexistingTask(){
fail("ActivitiException expected");
assertEquals(Task.class,ae.getObjectClass());
}