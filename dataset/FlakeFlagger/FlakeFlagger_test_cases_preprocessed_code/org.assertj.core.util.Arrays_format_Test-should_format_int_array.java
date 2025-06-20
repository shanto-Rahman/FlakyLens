@Test public void should_format_int_array(){
assertEquals("[78, 66]",Arrays.format(new StandardRepresentation(),array));
assertEquals("[78, 66]",Arrays.format(array));
}