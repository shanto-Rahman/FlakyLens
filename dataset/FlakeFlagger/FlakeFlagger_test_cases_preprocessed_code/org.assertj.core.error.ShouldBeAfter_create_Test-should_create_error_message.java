@Test public void should_create_error_message(){
assertEquals("[Test] \nExpecting:\n <2011-01-01T00:00:00>\nto be strictly after:\n <2012-01-01T00:00:00>",message);
}