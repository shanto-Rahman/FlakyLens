public void testJobCommandsWithTimer(){
assertEquals(0,acquiredJobs.size());
assertEquals(1,acquiredJobs.size());
assertEquals(jobId,job.getId());
assertEquals(0,tweetHandler.getMessages().size());
assertEquals("i'm coding a test",tweetHandler.getMessages().get(0));
assertEquals(1,tweetHandler.getMessages().size());
}