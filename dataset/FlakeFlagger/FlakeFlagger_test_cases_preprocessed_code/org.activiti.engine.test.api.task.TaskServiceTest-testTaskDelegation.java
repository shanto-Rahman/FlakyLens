public void testTaskDelegation(){
assertEquals("johndoe",task.getOwner());
assertEquals("joesmoe",task.getAssignee());
assertEquals(DelegationState.PENDING,task.getDelegationState());
fail();
assertEquals("johndoe",task.getOwner());
assertEquals("johndoe",task.getAssignee());
assertEquals(DelegationState.RESOLVED,task.getDelegationState());
assertEquals("johndoe",task.getOwner());
assertNull(task.getAssignee());
assertNull(task.getDelegationState());
assertEquals("johndoe",task.getOwner());
assertEquals("jackblack",task.getAssignee());
assertEquals(DelegationState.RESOLVED,task.getDelegationState());
}