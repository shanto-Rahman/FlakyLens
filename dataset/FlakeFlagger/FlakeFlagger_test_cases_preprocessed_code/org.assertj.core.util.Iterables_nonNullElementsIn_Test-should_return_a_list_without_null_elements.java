@Test public void should_return_a_list_without_null_elements(){
assertArrayEquals(new String[]{"Frodo","Sam"},nonNull.toArray());
}