@Test public void testHashCode(){
Assert.assertTrue(element1.hashCode() != element2.hashCode());
Assert.assertTrue(element1.hashCode() != element3.hashCode());
Assert.assertTrue(element2.hashCode() != element3.hashCode());
Assert.assertTrue(element3.hashCode() == element4.hashCode());
Assert.assertTrue(element1.hashCode() == element5.hashCode());
}