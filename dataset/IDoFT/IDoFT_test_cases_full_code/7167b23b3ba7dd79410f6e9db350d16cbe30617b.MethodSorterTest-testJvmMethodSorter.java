@Test public void testJvmMethodSorter(){
  Method[] fromJvmWithSynthetics=DummySortJvm.class.getDeclaredMethods();
  Method[] sorted=MethodSorter.getDeclaredMethods(DummySortJvm.class);
  assertArrayEquals(fromJvmWithSynthetics,sorted);
}
