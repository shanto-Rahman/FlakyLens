@Test @WithUserDetails(value="admin",userDetailsServiceBeanName="myUserDetailsService") public void validatingConfigurationForAdmin(){
assertThat(authenticatedUserId).isNotBlank();
assertThat(userDetails).isNotNull();
assertThat(userDetails.getAuthorities()).hasSize(1);
assertThat(userRoles).isNotNull();
assertThat(userRoles).hasSize(1);
assertThat(userRoles.get(0)).isEqualTo("ACTIVITI_ADMIN");
assertThat(userGroups).isNotNull();
assertThat(userGroups).hasSize(0);
}