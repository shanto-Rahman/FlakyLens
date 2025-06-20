@Test public void assertFindTaskResultStatisticsWithDifferentFromDate(){
assertTrue(repository.add(new TaskResultStatistics(100,0,each,yesterday)));
assertTrue(repository.add(new TaskResultStatistics(100,0,each,now)));
assertThat(repository.findTaskResultStatistics(yesterday,each).size(),is(2));
assertThat(repository.findTaskResultStatistics(now,each).size(),is(1));
}