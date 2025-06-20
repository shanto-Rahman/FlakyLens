@Deployment public void testAsyncScript(){
assertEquals(1,jobs.size());
assertEquals(0L,jobQuery.count());
}