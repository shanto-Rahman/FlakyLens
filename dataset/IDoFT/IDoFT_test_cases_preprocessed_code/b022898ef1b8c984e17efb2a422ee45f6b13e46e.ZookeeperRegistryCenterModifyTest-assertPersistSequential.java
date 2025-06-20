@Test public void assertPersistSequential() throws Exception {
assertThat(zkRegCenter.persistSequential("/sequential/test_sequential","test_value"),startsWith("/sequential/test_sequential"));//RW
assertThat(zkRegCenter.persistSequential("/sequential/test_sequential","test_value"),startsWith("/sequential/test_sequential"));//RW
assertThat(actual.size(),is(2));
assertThat(each,startsWith("test_sequential"));
assertThat(zkRegCenter.get("/sequential/" + each),startsWith("test_value"));//RW
}