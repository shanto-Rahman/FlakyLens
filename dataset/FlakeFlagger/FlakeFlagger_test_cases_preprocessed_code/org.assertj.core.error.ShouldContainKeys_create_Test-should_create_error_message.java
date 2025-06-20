@Test public void should_create_error_message(){
assertThat(message).isEqualTo("[Test] \nExpecting:\n <{\"name\"=\"Yoda\", \"color\"=\"green\"}>\nto contain key:\n <\"name\">");
}