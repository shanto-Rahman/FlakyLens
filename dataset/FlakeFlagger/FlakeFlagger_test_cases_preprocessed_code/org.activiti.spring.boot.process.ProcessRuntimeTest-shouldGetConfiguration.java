@Test @WithUserDetails(value="salaboy",userDetailsServiceBeanName="myUserDetailsService") public void shouldGetConfiguration(){
assertThat(configuration).isNotNull();
}