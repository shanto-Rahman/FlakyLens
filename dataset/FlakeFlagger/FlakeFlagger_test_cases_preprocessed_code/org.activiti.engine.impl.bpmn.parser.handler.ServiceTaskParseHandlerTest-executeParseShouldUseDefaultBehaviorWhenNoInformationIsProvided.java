@Test public void executeParseShouldUseDefaultBehaviorWhenNoInformationIsProvided() throws Exception {
assertThat(serviceTask.getBehavior()).isEqualTo(defaultBehavior);
}