@Test public void should_extract_field(){
assertThat(id).isEqualTo(1L);
assertThat(idObject).isInstanceOf(Long.class).isEqualTo(1L);
}