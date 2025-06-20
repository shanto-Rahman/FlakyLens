@Test(expected=IllegalArgumentException.class) public void rejectsNullConfiguration(){
  new RepositoryRestHandlerMapping(mappings,null);
}
