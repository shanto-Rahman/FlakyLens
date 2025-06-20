public void testHistoricVariableQueryByExecutionIds(){
if (i == 1) {
}
if (i != 1) {
}
assertThat(historyService.createHistoricVariableInstanceQuery().executionIds(testProcessInstanceIds).list().size()).isEqualTo((int)historyService.createHistoricVariableInstanceQuery().executionIds(testProcessInstanceIds).count()).isEqualTo(2);
assertThat(historicVariableInstances).hasSize(2).extracting("name","value").containsExactly(tuple("startVar","hello"),tuple("startVar","hello"));
assertThat(historicVariableInstances).hasSize(3).extracting("name","value").containsExactlyInAnyOrder(tuple("startVar","hello"),tuple("startVar","hello"),tuple("startVar2","hello2"));
}