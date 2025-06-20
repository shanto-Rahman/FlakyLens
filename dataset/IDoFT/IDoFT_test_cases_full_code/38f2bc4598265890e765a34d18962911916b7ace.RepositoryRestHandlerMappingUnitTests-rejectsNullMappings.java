@Test(expected=IllegalArgumentException.class) public void rejectsNullMappings(){
  new RepositoryRestHandlerMapping(null,configuration);
}
