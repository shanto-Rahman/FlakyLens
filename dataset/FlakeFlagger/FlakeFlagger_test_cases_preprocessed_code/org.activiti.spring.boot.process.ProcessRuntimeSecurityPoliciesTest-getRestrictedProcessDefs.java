@Test @WithUserDetails(value="salaboy",userDetailsServiceBeanName="myUserDetailsService") public void getRestrictedProcessDefs(){
assertThat(configuration).isNotNull();
assertThat(processDefinitionPage.getContent()).isNotNull();
assertThat(processDefinitionPage.getContent()).hasSize(2);
}