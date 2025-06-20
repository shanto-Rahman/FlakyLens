@Test public void should_create_error_message_when_only_elements_order_differs(){
assertThat(message).isEqualTo("[Test] \n" + "Actual and expected have the same elements but not in the same order, at index 1 actual element was:\n" + "  <\"Luke\">\n"+ "whereas expected element was:\n"+ "  <\"Han\">\n");
}