@Test public void restrictToKeysAddFilterOnGivenKeys(){
assertThat(filter.getProcessDefinitionKeys()).isEqualTo(keys);
}