@Test public void should_create_error_message_with_multiple_keys(){
assertThat(message).isEqualTo("[Test] \nExpecting:\n <{\"name\"=\"Yoda\", \"color\"=\"green\"}>\nto contain keys:\n <[\"name\", \"color\"]>");
}