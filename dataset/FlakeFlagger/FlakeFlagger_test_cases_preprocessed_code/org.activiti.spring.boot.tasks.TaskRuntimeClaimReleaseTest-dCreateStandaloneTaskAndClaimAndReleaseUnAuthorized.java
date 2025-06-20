@Test @WithUserDetails(value="garth",userDetailsServiceBeanName="myUserDetailsService") public void dCreateStandaloneTaskAndClaimAndReleaseUnAuthorized(){
assertThat(standAloneTask.getAssignee()).isNull();
assertThat(standAloneTask.getStatus()).isEqualTo(Task.TaskStatus.CREATED);
currentTaskId=standAloneTask.getId();//RW
}