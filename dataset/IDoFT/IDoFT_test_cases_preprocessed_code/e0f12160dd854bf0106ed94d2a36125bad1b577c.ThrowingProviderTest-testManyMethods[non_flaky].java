@Test public void testManyMethods(){
fail();
assertTrue((ManyMethods.class.getName() + " may not declare any new methods, but declared " + list).equals(message) || (ManyMethods.class.getName() + " may not declare any new methods, but declared " + reversedList).equals(message));
}