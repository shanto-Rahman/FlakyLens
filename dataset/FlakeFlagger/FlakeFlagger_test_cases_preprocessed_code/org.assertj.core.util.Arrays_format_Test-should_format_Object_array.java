@Test public void should_format_Object_array(){
assertEquals("[\"First\", 3]",Arrays.format(new StandardRepresentation(),array));
assertEquals("[\"First\", 3]",Arrays.format(array));
}