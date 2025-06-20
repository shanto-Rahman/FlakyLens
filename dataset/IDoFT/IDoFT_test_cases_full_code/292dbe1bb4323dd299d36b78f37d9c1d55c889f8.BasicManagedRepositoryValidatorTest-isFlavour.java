@Test void isFlavour(){
  BasicManagedRepositoryValidator validator=new BasicManagedRepositoryValidator(configurationHandler);
  validator.setRepositoryRegistry(repositoryRegistry);
  assertTrue(validator.isFlavour(ManagedRepository.class));
  assertTrue(validator.isFlavour(BasicManagedRepository.class));
}
