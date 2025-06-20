@Test @WithUserDetails(value="admin",userDetailsServiceBeanName="myUserDetailsService") public void getAllProcessDefsForAdmin(){
assertThat(processDefinitionPage.getContent()).isNotNull();
assertThat(processDefinitionPage.getContent()).hasSize(4);
}