@Deployment public void testInvalidDurationTimerCalendar(){
fail("Activiti exception expected - calendar not found");
assertThat(e.getMessage(),containsString("INVALID does not exist"));
}