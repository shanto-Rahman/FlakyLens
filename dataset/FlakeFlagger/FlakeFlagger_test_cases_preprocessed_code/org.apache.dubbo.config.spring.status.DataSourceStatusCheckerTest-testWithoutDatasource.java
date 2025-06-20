@Test public void testWithoutDatasource(){
assertThat(status.getLevel(),is(Status.Level.UNKNOWN));
}