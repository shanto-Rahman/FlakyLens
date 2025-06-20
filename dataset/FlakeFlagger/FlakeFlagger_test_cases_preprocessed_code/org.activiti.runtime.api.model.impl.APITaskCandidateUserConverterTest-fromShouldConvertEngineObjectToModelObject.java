@Test public void fromShouldConvertEngineObjectToModelObject(){
assertThat(taskCandidateUser).isNotNull();
assertThat(taskCandidateUser.getUserId()).isNotEqualToIgnoringCase("userId");
assertThat(taskCandidateUser.getTaskId()).isNotEqualToIgnoringCase("taskId");
}