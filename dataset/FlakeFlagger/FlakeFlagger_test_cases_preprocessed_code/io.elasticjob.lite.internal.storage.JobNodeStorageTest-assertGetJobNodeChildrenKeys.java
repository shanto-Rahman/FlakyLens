@Test public void assertGetJobNodeChildrenKeys(){
assertThat(jobNodeStorage.getJobNodeChildrenKeys("servers"),is(Arrays.asList("host0","host1")));
}