@Test @WithUserDetails(value="garth",userDetailsServiceBeanName="myUserDetailsService") public void cCreateStandaloneTaskReleaseUnAuthorized(){
assertThat(standAloneTask.getAssignee()).isNull();
assertThat(standAloneTask.getStatus()).isEqualTo(Task.TaskStatus.CREATED);
assertThat(thrown).isInstanceOf(IllegalStateException.class);
}