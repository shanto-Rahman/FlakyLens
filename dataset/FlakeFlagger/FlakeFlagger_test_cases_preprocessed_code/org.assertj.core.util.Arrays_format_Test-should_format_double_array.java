@Test public void should_format_double_array(){
assertEquals("[6.8, 8.3]",Arrays.format(new StandardRepresentation(),array));
assertEquals("[6.8, 8.3]",Arrays.format(array));
}