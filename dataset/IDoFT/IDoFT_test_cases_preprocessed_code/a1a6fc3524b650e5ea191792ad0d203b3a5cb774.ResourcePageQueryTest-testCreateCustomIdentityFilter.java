@Test public void testCreateCustomIdentityFilter(){
assertEquals(String.format("%s?startId=%s&count=%d",DEFAULT_URL,startId,count),resultRequestPath);
}