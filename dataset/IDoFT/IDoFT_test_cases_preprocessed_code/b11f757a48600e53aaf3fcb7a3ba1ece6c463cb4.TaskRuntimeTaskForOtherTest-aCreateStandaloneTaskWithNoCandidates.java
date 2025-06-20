@Test @WithUserDetails(value="garth",userDetailsServiceBeanName="myUserDetailsService") public void aCreateStandaloneTaskWithNoCandidates(){
assertThat(tasks.getContent()).hasSize(1);
assertThat(task.getAssignee()).isNull();
assertThat(task.getStatus()).isEqualTo(Task.TaskStatus.CREATED);
}