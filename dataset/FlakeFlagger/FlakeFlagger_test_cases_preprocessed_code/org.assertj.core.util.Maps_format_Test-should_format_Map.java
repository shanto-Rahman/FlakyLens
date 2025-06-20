@Test public void should_format_Map(){
assertThat(Maps.format(standardRepresentation,map)).isEqualTo("{\"One\"=java.lang.String, \"Two\"=java.io.File}");
assertThat(Maps.format(map)).isEqualTo("{\"One\"=java.lang.String, \"Two\"=java.io.File}");
}