@Test public void should_create_error_message_differentiating_double_from_float(){
assertEquals("[Test] \nExpecting:\n <[5.0, 7.0]>\nto contain:\n <[5.0f, 7.0f]>\nbut could not find:\n" + " <[5.0f, 7.0f]>\n",message);
}