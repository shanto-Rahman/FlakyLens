@Test public void boxOfFoo() throws Exception {
assertThat(testResult(BoxOfFoo.class),isSuccessful());
assertEquals(defaultPropertyTrialCount(),BoxOfFoo.iterations);//RW
}