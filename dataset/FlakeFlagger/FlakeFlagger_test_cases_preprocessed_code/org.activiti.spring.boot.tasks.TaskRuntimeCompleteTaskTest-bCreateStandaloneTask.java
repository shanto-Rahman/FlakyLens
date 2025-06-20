@Test @WithUserDetails(value="garth",userDetailsServiceBeanName="myUserDetailsService") public void bCreateStandaloneTask(){
assertThat(tasks.getContent()).hasSize(1);
assertThat(task.getAssignee()).isEqualTo(authenticatedUserId);
assertThat(task.getStatus()).isEqualTo(Task.TaskStatus.ASSIGNED);
currentTaskId=task.getId();//RW
}