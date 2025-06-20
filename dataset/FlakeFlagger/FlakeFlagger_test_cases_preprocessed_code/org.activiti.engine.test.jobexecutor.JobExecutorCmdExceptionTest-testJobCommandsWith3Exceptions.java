public void testJobCommandsWith3Exceptions(){
assertEquals(3,job.getRetries());
fail("exception expected");
assertEquals(2,job.getRetries());
fail("exception expected");
assertEquals(1,job.getRetries());
fail("exception expected");
assertNotNull(job);
}