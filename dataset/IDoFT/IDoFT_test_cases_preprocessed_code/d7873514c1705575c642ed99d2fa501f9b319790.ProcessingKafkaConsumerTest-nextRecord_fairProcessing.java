@Test public void nextRecord_fairProcessing(){
assertThat("Expected to remove [" + value + "] but it was not part of values ["+ values+ "]",values.remove(value),is(true));
assertThat(values,empty());
assertThat("expected optional consumer record to not be present",optional.isPresent(),is(false));
}