@Test public void testPartiallyRepaired(){
long repairIntervalInMs=TimeUnit.HOURS.toMillis(1);
assertThat(capturedVnodeStates).hasSize(1);
}