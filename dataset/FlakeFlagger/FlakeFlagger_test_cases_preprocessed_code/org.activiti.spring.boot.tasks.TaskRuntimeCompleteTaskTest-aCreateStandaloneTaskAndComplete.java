@Test @WithUserDetails(value="garth",userDetailsServiceBeanName="myUserDetailsService") public void aCreateStandaloneTaskAndComplete(){
assertThat(tasks.getContent()).hasSize(1);
assertThat(task.getAssignee()).isEqualTo(authenticatedUserId);
assertThat(task.getStatus()).isEqualTo(Task.TaskStatus.ASSIGNED);
assertThat(completedTask.getStatus()).isEqualTo(Task.TaskStatus.COMPLETED);
}