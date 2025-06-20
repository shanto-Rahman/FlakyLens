@Test public void getDataManagerShouldReturnIntegrationContextDataManager(){
assertThat(retrievedDataManager).isEqualTo(dataManager);
}