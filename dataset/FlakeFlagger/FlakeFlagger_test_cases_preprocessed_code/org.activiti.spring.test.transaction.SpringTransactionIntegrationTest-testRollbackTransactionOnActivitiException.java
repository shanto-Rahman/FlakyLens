@Deployment public void testRollbackTransactionOnActivitiException(){
assertEquals(Long.valueOf(0),jdbcTemplate.queryForObject("select count(*) from MY_TABLE",Long.class));
fail();
assertEquals("My Task",taskService.createTaskQuery().singleResult().getName());
assertEquals(Long.valueOf(0),jdbcTemplate.queryForObject("select count(*) from MY_TABLE",Long.class));
}