@Test public void should_create_error_message_for_Path_not_following_symbolic_links(){
assertThat(actualMessage).isEqualTo(expectedMessage);
}