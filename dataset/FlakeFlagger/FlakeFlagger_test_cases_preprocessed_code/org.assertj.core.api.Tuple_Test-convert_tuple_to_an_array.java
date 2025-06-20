@Test public void convert_tuple_to_an_array(){
assertThat(tuple.toArray()).isEqualTo(array("Yoda",800,"Jedi"));
}