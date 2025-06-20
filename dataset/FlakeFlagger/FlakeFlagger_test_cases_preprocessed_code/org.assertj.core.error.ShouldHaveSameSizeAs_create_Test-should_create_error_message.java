@Test public void should_create_error_message(){
assertThat(message).isEqualTo("[Test] \n" + "Actual and expected should have same size but actual size is:\n" + " <2>\n"+ "while expected is:\n"+ " <4>\n"+ "Actual was:\n"+ "<['a', 'b']>");
}