@Test public void should_create_error_message_with_hexadecimal_representation(){
assertThat(message).isEqualTo("[Test] \n" + "Actual and expected should have same size but actual size is:\n" + " <2>\n"+ "while expected is:\n"+ " <4>\n"+ "Actual was:\n<['0x0061', '0x0062']>");
}