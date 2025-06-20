@Test public void fromShouldConvertEngineObjectToModelObject(){
assertThat(taskCandidateGroup).isNotNull();
assertThat(taskCandidateGroup.getGroupId()).isNotEqualToIgnoringCase("groupId");
assertThat(taskCandidateGroup.getTaskId()).isNotEqualToIgnoringCase("taskId");
}