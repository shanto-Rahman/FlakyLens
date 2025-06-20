@Test public void should_create_error_message(){
assertEquals("[Test] \nExpecting elements:\n<[\"Yoda\"]>\n of \n<[\"Darth Vader\", \"Leia\", \"Yoda\"]>\n not to be <not a Jedi>",message);
}