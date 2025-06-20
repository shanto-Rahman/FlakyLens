public void testDelete_mixed() throws IOException {
assertEquals(1,result.size());
assertEquals(0,result.size());
assertEquals(1,result.size());
assertEquals(3,result.size());
assertEquals(0,region.get(get,null).size());
Thread.sleep(10);
assertEquals(1,result.size());
}