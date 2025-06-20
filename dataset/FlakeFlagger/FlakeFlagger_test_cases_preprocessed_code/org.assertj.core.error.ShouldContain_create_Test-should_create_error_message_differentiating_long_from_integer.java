@Test public void should_create_error_message_differentiating_long_from_integer(){
assertEquals("[Test] \nExpecting:\n <5L>\nto contain:\n <5>\nbut could not find:\n" + " <5>\n",message);
}