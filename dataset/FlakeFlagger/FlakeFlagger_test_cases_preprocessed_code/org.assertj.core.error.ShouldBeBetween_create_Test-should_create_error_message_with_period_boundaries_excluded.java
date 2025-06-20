@Test public void should_create_error_message_with_period_boundaries_excluded(){
assertEquals("[Test] \nExpecting:\n <2010-01-01T00:00:00>\nto be in period:\n ]2011-01-01T00:00:00, 2012-01-01T00:00:00[",message);
}