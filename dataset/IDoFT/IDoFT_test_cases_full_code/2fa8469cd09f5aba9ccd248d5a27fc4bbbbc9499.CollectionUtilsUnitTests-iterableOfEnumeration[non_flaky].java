@Test @SuppressWarnings("unchecked") public void iterableOfEnumeration(){
  Enumeration<Object> mockEnumeration=mock(Enumeration.class,"MockEnumeration");
  when(mockEnumeration.hasMoreElements()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);
  when(mockEnumeration.nextElement()).thenReturn(1).thenReturn(2).thenReturn(3).thenThrow(new NoSuchElementException("Enumeration exhausted"));
  Iterable<Object> iterable=CollectionUtils.iterable(mockEnumeration);
  assertThat(iterable).isNotNull();
  LinkedHashSet<Object> set=StreamSupport.stream(iterable.spliterator(),false).collect(Collectors.toCollection(LinkedHashSet::new));
  assertThat(set).containsExactly(1,2,3);
  verify(mockEnumeration,times(4)).hasMoreElements();
  verify(mockEnumeration,times(3)).nextElement();
}
