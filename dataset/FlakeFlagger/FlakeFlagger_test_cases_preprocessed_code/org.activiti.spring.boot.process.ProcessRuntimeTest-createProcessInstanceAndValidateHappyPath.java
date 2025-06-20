@Test @WithUserDetails(value="salaboy",userDetailsServiceBeanName="myUserDetailsService") public void createProcessInstanceAndValidateHappyPath(){
assertThat(RuntimeTestConfiguration.completedProcesses).contains(categorizeProcess.getId());
assertThat(categorizeProcess).isNotNull();
assertThat(categorizeProcess.getStatus()).isEqualTo(ProcessInstance.ProcessInstanceStatus.COMPLETED);
assertThat(RuntimeTestConfiguration.processImageConnectorExecuted).isEqualTo(true);
assertThat(RuntimeTestConfiguration.tagImageConnectorExecuted).isEqualTo(true);
assertThat(RuntimeTestConfiguration.discardImageConnectorExecuted).isEqualTo(false);
}