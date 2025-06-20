@Test public void denyAllShouldAddUnmatchableFilter(){
assertThat(filter.getProcessDefinitionKeys()).hasSize(1);
assertThat(filter.getProcessDefinitionKeys().iterator().next()).startsWith("missing-");
}