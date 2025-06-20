@Test public void assertNewWithoutSlaveId(){
assertThat(actual.getSlaveId(),is("unassigned-slave"));
}