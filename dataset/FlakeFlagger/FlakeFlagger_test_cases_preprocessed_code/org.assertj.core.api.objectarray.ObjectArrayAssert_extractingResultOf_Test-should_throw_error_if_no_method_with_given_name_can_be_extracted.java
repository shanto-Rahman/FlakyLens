@Test public void should_throw_error_if_no_method_with_given_name_can_be_extracted() throws Exception {
assertThat(jedis).extractingResultOf("unknown");//RW
}