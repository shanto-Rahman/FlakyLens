@Test public void testWithoutApplicationContext(){
assertThat(status.getLevel(),is(Status.Level.UNKNOWN));
}