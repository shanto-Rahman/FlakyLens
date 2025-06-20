@Test public void should_create_error_message_with_period_lower_boundary_included(){
assertEquals("[Test] \nExpecting:\n <2012-01-01T00:00:00>\nnot to be in period:\n [2011-01-01T00:00:00, 2012-01-01T00:00:00[",message);
}