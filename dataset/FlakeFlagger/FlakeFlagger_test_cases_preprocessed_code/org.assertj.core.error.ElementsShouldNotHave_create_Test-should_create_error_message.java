@Test public void should_create_error_message(){
assertEquals("[Test] \nExpecting elements:\n<[\"Leia\"]>\n of \n<[\"Yoda\", \"Luke\", \"Leia\"]>\n not to have <jedi power>",message);
}