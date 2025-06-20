@Test public void should_return_hashCode_of_intarray(){
assertThat(hashCodeFor(intArray)).isEqualTo(intArray.hashCode());
}