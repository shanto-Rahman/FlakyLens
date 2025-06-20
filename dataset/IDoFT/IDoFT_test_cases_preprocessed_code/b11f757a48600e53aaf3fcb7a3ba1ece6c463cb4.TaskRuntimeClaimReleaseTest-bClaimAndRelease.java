@Test @WithUserDetails(value="salaboy",userDetailsServiceBeanName="myUserDetailsService") public void bClaimAndRelease(){
Task claimedTask=taskRuntime.claim(TaskPayloadBuilder.claim().withTaskId(currentTaskId).build());//RW
assertThat(claimedTask.getAssignee()).isEqualTo(authenticatedUserId);
assertThat(claimedTask.getStatus()).isEqualTo(Task.TaskStatus.ASSIGNED);
assertThat(releasedTask.getAssignee()).isNull();
assertThat(releasedTask.getStatus()).isEqualTo(Task.TaskStatus.CREATED);
}