@Test public void voidParameter() throws Exception {
assertThat(testResult(VoidParameter.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),VoidParameter.iterations);//RW
VoidParameter.iterations=0;//RW
}