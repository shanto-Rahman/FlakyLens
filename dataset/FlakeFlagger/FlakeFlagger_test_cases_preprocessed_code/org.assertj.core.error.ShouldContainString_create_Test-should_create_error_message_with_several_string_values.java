@Test public void should_create_error_message_with_several_string_values(){
assertEquals("[Test] \nExpecting:\n <\"Yoda, Luke\">\nto contain:\n <[\"Luke\", \"Vador\", \"Solo\"]>\nbut could not find:\n <[\"Vador\", \"Solo\"]>\n ",message);
}