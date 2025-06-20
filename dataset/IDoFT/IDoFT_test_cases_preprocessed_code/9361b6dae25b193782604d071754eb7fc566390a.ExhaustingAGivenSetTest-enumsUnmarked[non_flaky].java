@Test public void enumsUnmarked(){
assertThat(testResult(EnumsUnmarked.class),isSuccessful());
assertEquals(EnumSet.allOf(RoundingMode.class).size(),EnumsUnmarked.iterations);//RW
assertEquals(EnumSet.allOf(RoundingMode.class),EnumsUnmarked.testCases);
EnumsUnmarked.iterations=0;//RW
}