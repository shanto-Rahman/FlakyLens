public void testInvalidCalendarNameRequest(){
fail("ActivitiException expected");
assertThat(e.getMessage(),containsString("INVALID does not exist"));
}