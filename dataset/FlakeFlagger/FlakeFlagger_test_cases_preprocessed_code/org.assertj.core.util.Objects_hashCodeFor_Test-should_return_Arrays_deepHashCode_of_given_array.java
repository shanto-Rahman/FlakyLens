@Test public void should_return_Arrays_deepHashCode_of_given_array(){
assertThat(hashCodeFor(array)).isEqualTo(deepHashCode(array));
assertThat(hashCodeFor(intArray)).isEqualTo(deepHashCode(intArray));
}