@Test public void wrapperBooleanWithValuesOf(){
assertThat(testResult(WrapperBooleanWithValuesOf.class),isSuccessful());
assertEquals(repeat(asList(false,true),50),WrapperBooleanWithValuesOf.values);//RW
}