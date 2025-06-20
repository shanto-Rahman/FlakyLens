public void testBaseProperties(){
assertNotNull(log.getId());
assertNotNull(log.getProcessDefinitionId());
assertNotNull(log.getStartActivityId());
assertNotNull(log.getDurationInMillis());
assertNotNull(log.getEndTime());
assertNotNull(log.getStartTime());
}