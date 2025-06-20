@Test @WithUserDetails(value="salaboy",userDetailsServiceBeanName="myUserDetailsService") public void eCreateStandaloneTaskAndClaimAndReleaseUnAuthorized(){
Task claimedTask=taskRuntime.claim(TaskPayloadBuilder.claim().withTaskId(currentTaskId).build());//RW
assertThat(claimedTask.getAssignee()).isEqualTo(authenticatedUserId);
assertThat(claimedTask.getStatus()).isEqualTo(Task.TaskStatus.ASSIGNED);
}