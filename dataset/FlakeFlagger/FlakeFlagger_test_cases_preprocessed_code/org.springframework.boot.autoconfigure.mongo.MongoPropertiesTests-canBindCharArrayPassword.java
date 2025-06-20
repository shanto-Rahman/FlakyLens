@Test public void canBindCharArrayPassword(){
assertThat(properties.getPassword(),equalTo("word".toCharArray()));
}