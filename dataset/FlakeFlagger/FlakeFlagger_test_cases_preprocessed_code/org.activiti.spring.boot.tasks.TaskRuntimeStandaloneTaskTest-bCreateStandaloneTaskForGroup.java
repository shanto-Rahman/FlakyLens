@Test @WithUserDetails(value="garth",userDetailsServiceBeanName="myUserDetailsService") public void bCreateStandaloneTaskForGroup(){
assertThat(tasks.getContent()).hasSize(1);
assertThat(task.getAssignee()).isNull();
assertThat(task.getStatus()).isEqualTo(Task.TaskStatus.CREATED);
assertThat(claimedTask.getAssignee()).isEqualTo(securityManager.getAuthenticatedUserId());
assertThat(claimedTask.getStatus()).isEqualTo(Task.TaskStatus.ASSIGNED);
assertThat(deletedTask).isNotNull();
assertThat(deletedTask.getStatus()).isEqualTo(Task.TaskStatus.DELETED);
assertThat(tasks.getContent()).hasSize(0);
}