@SuppressWarnings("unchecked") @Test public void testGenericReferenceException(){
Assert.assertEquals(1,users.size());
Assert.assertEquals("actual.provider",users.get(0).get("name"));
}