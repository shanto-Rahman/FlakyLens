@Test public void testHashCode(){
Assert.assertTrue(param1.hashCode() != param2.hashCode());
Assert.assertTrue(param1.hashCode() == param3.hashCode());
}