@Test public void using_custom_comparator_test(){
assertSame(assertions.objects.getComparator(),comparator);
assertSame(assertions.bytes.getComparator(),comparator);
}