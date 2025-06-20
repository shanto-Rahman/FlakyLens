@Test public void should_return_a_Collection_without_null_elements(){
assertArrayEquals(new String[]{"Frodo","Sam"},nonNull.toArray());
}