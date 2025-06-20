@Test void idHasAnnotatedIdAndMultipleIdFields(){
converter.write(entity,converted);//RW
assertThat(converted.getId()).isEqualTo(entity.annotatedId);
}