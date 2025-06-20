@Test public void database(){
assertNotNull(health.getDetails().get("database"));
assertNotNull(health.getDetails().get("hello"));
}