@Test public void getManagedEntityClassShouldReturnIntegrationContextEntityImpl(){
assertThat(managedEntityClass).isEqualTo(IntegrationContextEntityImpl.class);
}