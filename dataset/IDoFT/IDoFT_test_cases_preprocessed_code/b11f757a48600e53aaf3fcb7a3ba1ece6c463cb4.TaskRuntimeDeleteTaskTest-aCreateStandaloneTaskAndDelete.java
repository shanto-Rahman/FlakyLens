@Test @WithUserDetails(value="garth",userDetailsServiceBeanName="myUserDetailsService") public void aCreateStandaloneTaskAndDelete(){
assertThat(tasks.getContent()).hasSize(1);
assertThat(task.getAssignee()).isEqualTo(authenticatedUserId);
assertThat(task.getStatus()).isEqualTo(Task.TaskStatus.ASSIGNED);
assertThat(deletedTask.getStatus()).isEqualTo(Task.TaskStatus.DELETED);
}