@Test @WithUserDetails(value="garth",userDetailsServiceBeanName="myUserDetailsService") public void cCreateStandaloneTaskForGroupAndClaim(){
assertThat(tasks.getContent()).hasSize(1);
assertThat(task.getAssignee()).isNull();
assertThat(task.getStatus()).isEqualTo(Task.TaskStatus.CREATED);
assertThat(claimedTask.getAssignee()).isEqualTo(authenticatedUserId);
assertThat(claimedTask.getStatus()).isEqualTo(Task.TaskStatus.ASSIGNED);
}