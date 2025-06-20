@Test @WithUserDetails(value="salaboy",userDetailsServiceBeanName="myUserDetailsService") public void validatingConfigurationForUser(){
assertThat(authenticatedUserId).isNotBlank();
assertThat(userDetails).isNotNull();
assertThat(userDetails.getAuthorities()).hasSize(2);
assertThat(userRoles).isNotNull();
assertThat(userRoles).hasSize(1);
assertThat(userRoles.get(0)).isEqualTo("ACTIVITI_USER");
assertThat(userGroups).isNotNull();
assertThat(userGroups).hasSize(1);
assertThat(userGroups.get(0)).isEqualTo("activitiTeam");
}