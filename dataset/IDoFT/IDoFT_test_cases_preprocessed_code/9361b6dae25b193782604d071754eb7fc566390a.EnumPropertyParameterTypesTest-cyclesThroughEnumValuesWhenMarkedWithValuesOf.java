@Test public void cyclesThroughEnumValuesWhenMarkedWithValuesOf(){
assertThat(testResult(EnumWithValuesOf.class),isSuccessful());
assertEquals(repeat(asList(E1,E2,E3,E4,E5),20),EnumWithValuesOf.values);//RW
}