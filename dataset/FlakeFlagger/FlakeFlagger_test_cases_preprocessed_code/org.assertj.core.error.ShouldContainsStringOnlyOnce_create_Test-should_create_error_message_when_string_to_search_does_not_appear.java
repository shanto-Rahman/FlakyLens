@Test public void should_create_error_message_when_string_to_search_does_not_appear(){
assertEquals("[Test] \nExpecting:\n <\"motif\">\nto appear only once in:\n <\"aaamodifmoifaabbbmotfaaa\">\nbut it did not appear ",message);
}