@Test public void canGenerateSubClassForPrivateConstructor(){
assertThat(randomInstance,notNullValue());
assertThat(randomInstance.toString(),notNullValue());
}