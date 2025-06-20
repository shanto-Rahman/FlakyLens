@Test public void should_create_error_message(){
assertThat(message).isEqualTo("[Test] \n" + "Expecting\n" + "  <org.assertj.core.error.ShouldBeAssignableFrom_create_Test>\n"+ "to be assignable from:\n"+ "  <[java.lang.String, java.lang.Integer]>\n"+ "but was not assignable from:\n"+ "  <[java.lang.String]>");
}