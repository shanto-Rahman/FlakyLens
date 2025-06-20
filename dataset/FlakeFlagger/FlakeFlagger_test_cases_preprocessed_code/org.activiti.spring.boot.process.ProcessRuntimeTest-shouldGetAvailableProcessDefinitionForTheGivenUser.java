@Test @WithUserDetails(value="salaboy",userDetailsServiceBeanName="myUserDetailsService") public void shouldGetAvailableProcessDefinitionForTheGivenUser(){
assertThat(processDefinitionPage.getContent()).isNotNull();
assertThat(processDefinitionPage.getContent()).extracting(ProcessDefinition::getKey).contains(CATEGORIZE_PROCESS,CATEGORIZE_HUMAN_PROCESS);
}