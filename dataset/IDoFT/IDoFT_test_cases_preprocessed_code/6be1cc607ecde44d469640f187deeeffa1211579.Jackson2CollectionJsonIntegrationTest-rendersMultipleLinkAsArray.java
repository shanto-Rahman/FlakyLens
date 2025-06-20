@Test void rendersMultipleLinkAsArray(){
assertThat(mapper.writeObject(resourceSupport)).isEqualTo(mapper.readFileContent("resource-support-2.json"));
}