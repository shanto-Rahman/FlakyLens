@Test void idHasMultiplePrefixesAndSuffixesSameOrder(){
converter.write(entity,converted);//RW
assertThat(converted.getId()).isEqualTo(entity.id);
assertThat(converted.getId()).isEqualTo(entity.prefix1 + '.' + entity.someId+ '.'+ entity.suffix);
}