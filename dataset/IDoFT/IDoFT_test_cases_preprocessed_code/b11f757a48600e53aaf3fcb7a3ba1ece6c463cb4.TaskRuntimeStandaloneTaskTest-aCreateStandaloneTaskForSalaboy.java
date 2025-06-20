@Test @WithUserDetails(value="salaboy",userDetailsServiceBeanName="myUserDetailsService") public void aCreateStandaloneTaskForSalaboy(){
assertThat(RuntimeTestConfiguration.createdTasks).contains(standAloneTask.getId());
assertThat(tasks.getContent()).hasSize(1);
assertThat(task.getAssignee()).isEqualTo(authenticatedUserId);
assertThat(task.getStatus()).isEqualTo(Task.TaskStatus.ASSIGNED);
assertThat(deletedTask).isNotNull();
assertThat(deletedTask.getStatus()).isEqualTo(Task.TaskStatus.DELETED);
assertThat(tasks.getContent()).hasSize(0);
}