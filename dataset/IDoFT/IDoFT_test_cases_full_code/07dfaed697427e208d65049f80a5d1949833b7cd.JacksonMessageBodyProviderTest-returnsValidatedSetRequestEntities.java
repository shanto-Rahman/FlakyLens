@Test public void returnsValidatedSetRequestEntities() throws Exception {
  testValidatedCollectionType(Set.class,new TypeReference<Set<Example>>(){
  }
.getType());
}
