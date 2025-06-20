@Test(expected=AccessDeniedException.class) @WithUserDetails(value="admin",userDetailsServiceBeanName="myUserDetailsService") public void userFailTest(){
}