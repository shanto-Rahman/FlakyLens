@Test public void error(){
assertThat(health.getDetails().get("database"),notNullValue());
assertEquals(Status.DOWN,health.getStatus());
}