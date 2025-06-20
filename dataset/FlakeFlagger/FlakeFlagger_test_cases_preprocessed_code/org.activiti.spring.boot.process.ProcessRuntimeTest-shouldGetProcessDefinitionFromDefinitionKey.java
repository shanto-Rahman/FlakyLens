@Test @WithUserDetails(value="salaboy",userDetailsServiceBeanName="myUserDetailsService") public void shouldGetProcessDefinitionFromDefinitionKey(){
assertThat(categorizeHumanProcess).isNotNull();
assertThat(categorizeHumanProcess.getName()).isEqualTo(CATEGORIZE_HUMAN_PROCESS);
assertThat(categorizeHumanProcess.getId()).contains(CATEGORIZE_HUMAN_PROCESS);
}