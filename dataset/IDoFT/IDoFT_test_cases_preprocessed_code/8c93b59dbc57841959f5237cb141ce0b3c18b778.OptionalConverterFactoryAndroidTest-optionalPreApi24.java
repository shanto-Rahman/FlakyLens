@Config(sdk=21) @Test public void optionalPreApi24(){
fail();
assertThat(e).hasMessage("Unable to create converter for java.util.Optional<java.lang.Object>\n" + "    for method Service.optional");
}