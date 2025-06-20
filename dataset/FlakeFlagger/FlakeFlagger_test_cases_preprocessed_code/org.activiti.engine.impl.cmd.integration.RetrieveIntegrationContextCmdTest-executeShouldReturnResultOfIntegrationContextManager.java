@Test public void executeShouldReturnResultOfIntegrationContextManager(){
assertThat(executeResult).isEqualTo(contextEntity);
}