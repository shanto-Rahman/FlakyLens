@Test public void should_throw_null_pointer_exception_when_extracting_from_null() throws Exception {
assertThat(new CartoonCharacter[]{homer,null}).flatExtracting(children);
}