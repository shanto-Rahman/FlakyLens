public void testTaskDelegationThroughServiceCall(){
assertEquals("johndoe",task.getOwner());
assertEquals("joesmoe",task.getAssignee());
assertEquals(DelegationState.PENDING,task.getDelegationState());
assertEquals("johndoe",task.getOwner());
assertEquals("johndoe",task.getAssignee());
assertEquals(DelegationState.RESOLVED,task.getDelegationState());
}