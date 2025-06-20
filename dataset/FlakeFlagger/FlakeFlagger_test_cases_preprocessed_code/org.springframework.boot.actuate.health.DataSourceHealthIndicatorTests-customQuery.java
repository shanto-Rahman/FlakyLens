@Test public void customQuery(){
assertNotNull(health.getDetails().get("database"));
assertEquals(Status.UP,health.getStatus());
assertNotNull(health.getDetails().get("hello"));
}