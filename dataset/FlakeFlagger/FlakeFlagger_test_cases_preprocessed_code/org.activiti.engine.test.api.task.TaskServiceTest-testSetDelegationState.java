/** 
 * @see  <a href="https://activiti.atlassian.net/browse/ACT-1059">https://activiti.atlassian.net/browse/ACT-1059</a>
 */
public void testSetDelegationState(){
assertEquals("wuzh",task.getOwner());
assertEquals("other",task.getAssignee());
assertEquals(DelegationState.PENDING,task.getDelegationState());
assertEquals("wuzh",task.getOwner());
assertEquals("other",task.getAssignee());
assertEquals(DelegationState.RESOLVED,task.getDelegationState());
}