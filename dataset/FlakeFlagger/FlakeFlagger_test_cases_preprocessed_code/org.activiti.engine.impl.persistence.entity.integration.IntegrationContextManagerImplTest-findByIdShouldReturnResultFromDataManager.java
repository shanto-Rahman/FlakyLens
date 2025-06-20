@Test public void findByIdShouldReturnResultFromDataManager(){
assertThat(retrievedResult).isEqualTo(entity);
}