@Test public void smoke() throws Exception {
assertEquals(oldErrorCount,IncAction.errorCount);
assertEquals(oldBeginCount + 1,IncAction.beginCount);
assertEquals(oldEndCount + 1,IncAction.endCount);
}