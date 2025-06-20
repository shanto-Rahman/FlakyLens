@Test public void shouldDifferWhenContainingDifferentAttributes(){
assertFalse(key1.equals(key2));
assertFalse(key1.hashCode() == key2.hashCode());
}