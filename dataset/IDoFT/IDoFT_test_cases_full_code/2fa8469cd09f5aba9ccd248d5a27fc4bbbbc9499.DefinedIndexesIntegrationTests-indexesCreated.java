@Test public void indexesCreated(){
  QueryService queryService=gemfireCache.getQueryService();
  List<String> expectedDefinedIndexNames=Arrays.asList(id.getName(),birthDate.getName(),name.getName());
  assertThat(definedIndexNames).isEqualTo(expectedDefinedIndexNames);
  assertThat(id).isEqualTo(queryService.getIndex(people,id.getName()));
  assertThat(birthDate).isEqualTo(queryService.getIndex(people,birthDate.getName()));
  assertThat(lastName).isEqualTo(queryService.getIndex(people,lastName.getName()));
  assertThat(name).isEqualTo(queryService.getIndex(people,name.getName()));
}
