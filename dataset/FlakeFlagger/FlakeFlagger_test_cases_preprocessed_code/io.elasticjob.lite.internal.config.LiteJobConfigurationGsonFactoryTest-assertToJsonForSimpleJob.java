@Test public void assertToJsonForSimpleJob(){
assertThat(LiteJobConfigurationGsonFactory.toJson(actual),is(simpleJobJson));
}