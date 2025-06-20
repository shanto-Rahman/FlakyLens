public void testQueryByExecutionId(){
assertEquals(query.singleResult().getId(),job.getId());
}