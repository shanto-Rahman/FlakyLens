@Test public void assertGetAvailableJobInstances(){
assertThat(instanceService.getAvailableJobInstances(),is(Collections.singletonList(new JobInstance("127.0.0.1@-@0"))));
}