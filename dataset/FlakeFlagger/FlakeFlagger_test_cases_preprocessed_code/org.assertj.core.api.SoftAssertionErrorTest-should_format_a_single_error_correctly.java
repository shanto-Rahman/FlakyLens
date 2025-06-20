@Test public void should_format_a_single_error_correctly(){
assertThat(error.getMessage()).isEqualTo("\nThe following assertion failed:\n1) One\n");
}