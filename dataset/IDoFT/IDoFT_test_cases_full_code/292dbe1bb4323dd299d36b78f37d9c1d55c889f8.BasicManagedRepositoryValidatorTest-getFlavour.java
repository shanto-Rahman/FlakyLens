@Test void getFlavour(){
  BasicManagedRepositoryValidator validator=new BasicManagedRepositoryValidator(configurationHandler);
  validator.setRepositoryRegistry(repositoryRegistry);
  assertEquals(ManagedRepository.class,validator.getFlavour());
}
