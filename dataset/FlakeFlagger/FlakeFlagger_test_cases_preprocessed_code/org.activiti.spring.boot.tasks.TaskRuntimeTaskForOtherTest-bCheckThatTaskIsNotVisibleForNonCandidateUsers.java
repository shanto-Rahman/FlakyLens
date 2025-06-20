@Test @WithUserDetails(value="salaboy",userDetailsServiceBeanName="myUserDetailsService") public void bCheckThatTaskIsNotVisibleForNonCandidateUsers(){
assertThat(tasks.getContent()).hasSize(0);
}