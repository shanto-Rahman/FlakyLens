@Test public void primitiveLongs() throws Exception {
assertThat(testResult(PrimitiveLongs.class),isSuccessful());
assertEquals(3,PrimitiveLongs.iterations);//RW
assertEquals(new HashSet<>(asList(-6L,-7L,-8L)),PrimitiveLongs.testCases);
}