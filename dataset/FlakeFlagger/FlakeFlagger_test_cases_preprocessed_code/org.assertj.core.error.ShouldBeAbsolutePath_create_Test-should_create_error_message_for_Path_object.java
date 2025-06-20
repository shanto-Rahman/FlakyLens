@Test public void should_create_error_message_for_Path_object(){
assertThat(actualMessage).isEqualTo(format("[Test] " + SHOULD_BE_ABSOLUTE_PATH,path));
}