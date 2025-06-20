@Test public void manyParametersWithBooleanAndEnum(){
assertThat(testResult(ManyParametersWithBooleanAndEnum.class),isSuccessful());
assertEquals(expectedCount,ManyParametersWithBooleanAndEnum.iterations);//RW
assertEquals(String.valueOf(i),asList(3,7),ManyParametersWithBooleanAndEnum.firstTestCases.subList(i * 4,i * 4 + 2));
assertEquals(String.valueOf(i),asList('a','a','a','a','b','b','b','b','c','c','c','c'),ManyParametersWithBooleanAndEnum.secondTestCases.subList(i * 16,i * 16 + 12));
assertEquals(asList(false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false),ManyParametersWithBooleanAndEnum.thirdTestCases.subList(i * 32,i * 32 + 16));
assertEquals(asList(true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true),ManyParametersWithBooleanAndEnum.thirdTestCases.subList(i * 32 + 16,i * 32 + 32));
assertEquals(expectedCount,ManyParametersWithBooleanAndEnum.fourthTestCases.size());
assertEquals(EnumSet.allOf(RoundingMode.class),new HashSet<>(ManyParametersWithBooleanAndEnum.fourthTestCases));
ManyParametersWithBooleanAndEnum.iterations=0;//RW
}