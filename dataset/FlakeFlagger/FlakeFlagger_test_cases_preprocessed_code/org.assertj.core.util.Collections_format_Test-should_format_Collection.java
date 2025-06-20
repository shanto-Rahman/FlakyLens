@Test public void should_format_Collection(){
assertThat(Collections.format(new StandardRepresentation(),list)).isEqualTo("[\"First\", 3]");
assertThat(Collections.format(list)).isEqualTo("[\"First\", 3]");
assertThat(Collections.format(new StandardRepresentation(),list,"(",")")).isEqualTo("(\"First\", 3)");
assertThat(Collections.format(list,"(",")")).isEqualTo("(\"First\", 3)");
}