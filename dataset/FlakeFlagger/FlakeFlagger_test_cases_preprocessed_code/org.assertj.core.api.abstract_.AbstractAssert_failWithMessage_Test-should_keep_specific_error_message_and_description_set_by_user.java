@Test public void should_keep_specific_error_message_and_description_set_by_user(){
assertThat(e).hasMessage("[test context] my 5 errors !");
}