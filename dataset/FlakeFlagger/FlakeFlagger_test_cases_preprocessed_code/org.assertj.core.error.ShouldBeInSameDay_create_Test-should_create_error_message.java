@Test public void should_create_error_message(){
assertEquals("[Test] \nExpecting:\n <2010-01-01T00:00:00>\nto be on same year, month and day as:\n <2010-01-25T00:00:00>",message);
}