@Test public void should_create_AssertionError_with_message_differentiating_expected_double_and_actual_float(){
assertThat(error.getMessage()).isEqualTo("[my test] expected:<42.0[]> but was:<42.0[f]>");
}