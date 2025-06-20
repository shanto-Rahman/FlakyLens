@Test public void testCreateCustomIndexFilter(){
assertEquals(String.format("%s?startIndex=%d&count=%d",DEFAULT_URL,startIndex,count),resultRequestPath);
}