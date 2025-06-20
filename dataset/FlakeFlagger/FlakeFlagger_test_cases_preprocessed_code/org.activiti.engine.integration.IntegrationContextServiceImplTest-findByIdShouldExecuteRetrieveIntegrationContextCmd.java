@Test public void findByIdShouldExecuteRetrieveIntegrationContextCmd(){
assertThat(commandResult).isEqualTo(entity);
}