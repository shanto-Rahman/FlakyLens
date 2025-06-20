@Test public void should_format_short_array(){
assertEquals("[5, 8]",Arrays.format(new StandardRepresentation(),array));
assertEquals("[5, 8]",Arrays.format(array));
}