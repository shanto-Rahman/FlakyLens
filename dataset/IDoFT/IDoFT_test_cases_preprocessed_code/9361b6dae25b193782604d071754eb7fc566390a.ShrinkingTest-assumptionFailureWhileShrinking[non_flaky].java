@Test public void assumptionFailureWhileShrinking(){
assertThat(testResult(FailedAssumptionDuringShrinking.class),hasSingleFailureContaining("With arguments: ["));
FailedAssumptionDuringShrinking.shrinking=false;//RW
}