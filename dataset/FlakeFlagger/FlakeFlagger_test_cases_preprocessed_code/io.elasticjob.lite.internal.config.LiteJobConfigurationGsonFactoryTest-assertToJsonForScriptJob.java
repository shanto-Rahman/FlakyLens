@Test public void assertToJsonForScriptJob(){
assertThat(LiteJobConfigurationGsonFactory.toJson(actual),is(scriptJobJson));
}