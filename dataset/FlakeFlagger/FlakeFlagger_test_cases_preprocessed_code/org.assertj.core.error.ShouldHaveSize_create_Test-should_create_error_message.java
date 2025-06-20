@Test public void should_create_error_message(){
assertThat(message).isEqualTo("[Test] \nExpected size:<2> but was:<4> in:\n<['a', 'b']>");
}