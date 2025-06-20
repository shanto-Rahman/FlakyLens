@Test @WithUserDetails(value="salaboy",userDetailsServiceBeanName="myUserDetailsService") public void deleteProcessInstance(){
assertThat(configuration).isNotNull();
assertThat(processDefinitionPage.getContent()).isNotNull();
assertThat(processDefinitionPage.getContent()).extracting((ProcessDefinition pd) -> pd.getKey()).contains(CATEGORIZE_HUMAN_PROCESS);
assertThat(categorizeProcess).isNotNull();
assertThat(categorizeProcess.getStatus()).isEqualTo(ProcessInstance.ProcessInstanceStatus.RUNNING);
assertThat(processInstancePage).isNotNull();
assertThat(processInstancePage.getContent()).hasSize(1);
assertThat(deletedProcessInstance).isNotNull();
assertThat(deletedProcessInstance.getStatus()).isEqualTo(ProcessInstance.ProcessInstanceStatus.DELETED);
assertThat(processInstancePage).isNotNull();
assertThat(processInstancePage.getContent()).hasSize(0);
}