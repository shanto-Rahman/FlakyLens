@Test public void should_create_error_message(){
assertThat(actualMessage).isEqualTo(String.format("[Test] " + PATH_SHOULD_END_WITH,actual,other));
}