@Test public void should_format_Map_containing_itself(){
assertThat(Maps.format(standardRepresentation,map)).isEqualTo("{\"One\"=\"First\", \"Myself\"=(this Map)}");
assertThat(Maps.format(map)).isEqualTo("{\"One\"=\"First\", \"Myself\"=(this Map)}");
}