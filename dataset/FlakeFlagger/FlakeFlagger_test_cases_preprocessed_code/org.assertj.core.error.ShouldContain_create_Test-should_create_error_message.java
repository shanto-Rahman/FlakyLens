@Test public void should_create_error_message(){
assertEquals("[Test] \nExpecting:\n <[\"Yoda\"]>\nto contain:\n <[\"Luke\", \"Yoda\"]>\nbut could not find:\n" + " <[\"Luke\"]>\n",message);
}