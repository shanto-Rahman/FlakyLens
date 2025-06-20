@Test public void assertFindLatestTaskResultStatisticsWhenTableIsEmpty(){
assertFalse(repository.findLatestTaskResultStatistics(each).isPresent());
}