@Test @WithUserDetails(value="garth",userDetailsServiceBeanName="myUserDetailsService") public void aCreateStandaloneTaskForAnotherAssignee(){
assertThat(tasks.getContent()).hasSize(1);
assertThat(task.getAssignee()).isEqualTo("salaboy");
assertThat(task.getStatus()).isEqualTo(Task.TaskStatus.ASSIGNED);
}