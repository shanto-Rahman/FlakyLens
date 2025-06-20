@Test public void should_format_byte_array(){
assertEquals("[3, 8]",Arrays.format(new StandardRepresentation(),array));
assertEquals("[3, 8]",Arrays.format(array));
}