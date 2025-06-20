@Test public void should_pass(){
assertTrue(list.contains("Frodo"));
assertFalse(list.contains("Frodo"));
assertFalse(list.contains(null));
}