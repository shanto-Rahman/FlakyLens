@Test public void should_create_error_message_differentiating_long_from_integer_in_arrays(){
assertEquals("[Test] \nExpecting:\n <[5L, 7L]>\nto contain:\n <[5, 7]>\nbut could not find:\n" + " <[5, 7]>\n",message);
}