@Test public void testSetAndGet(){
Assert.assertTrue("set is not equals get",Objects.equals(testVal,internalThreadLocal.get()));
}