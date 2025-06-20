@Test public void smoke(){
assertEquals(Status.ERROR,bsm.getLevel());
assertNotNull(statusList);
assertEquals(1,statusList.size());
assertEquals("hello",statusList.get(0).getMessage());
}