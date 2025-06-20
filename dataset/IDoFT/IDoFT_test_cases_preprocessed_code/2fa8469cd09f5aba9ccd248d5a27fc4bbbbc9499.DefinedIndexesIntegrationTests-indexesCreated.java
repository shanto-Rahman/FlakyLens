@Test public void indexesCreated(){
assertThat(definedIndexNames).isEqualTo(expectedDefinedIndexNames);
assertThat(id).isEqualTo(queryService.getIndex(people,id.getName()));
assertThat(birthDate).isEqualTo(queryService.getIndex(people,birthDate.getName()));
assertThat(lastName).isEqualTo(queryService.getIndex(people,lastName.getName()));
assertThat(name).isEqualTo(queryService.getIndex(people,name.getName()));
}