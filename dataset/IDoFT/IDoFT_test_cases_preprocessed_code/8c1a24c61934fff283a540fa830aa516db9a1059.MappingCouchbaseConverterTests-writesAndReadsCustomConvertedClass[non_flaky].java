@Test void writesAndReadsCustomConvertedClass(){
converter.setCustomConversions(customConversions);//RW
converter.afterPropertiesSet();//RW
((CouchbaseMappingContext)converter.getMappingContext()).setSimpleTypeHolder(customConversions.getSimpleTypeHolder());//RW
converter.write(entity,converted);//RW
assertThat(valueStr).isEqualTo(((CouchbaseList)converted.getContent().get("listOfValues")).get(0));
assertThat(value2Str).isEqualTo(((CouchbaseList)converted.getContent().get("listOfValues")).get(1));
assertThat(converted.getContent().get("listOfValues").toString()).isEqualTo(source.getContent().get("listOfValues").toString());
assertThat(sourceVals.getContent().get("val1").toString()).isEqualTo(convertedVals.getContent().get("val1").toString());
assertThat(sourceVals.getContent().get("val2").toString()).isEqualTo(convertedVals.getContent().get("val2").toString());
CustomEntity readConverted=converter.read(CustomEntity.class,source);//RW
assertThat(readConverted.value).isEqualTo(value);
assertThat(readConverted.listOfValues.get(0)).isEqualTo(listOfValues.get(0));
assertThat(readConverted.listOfValues.get(1)).isEqualTo(listOfValues.get(1));
assertThat(readConverted.mapOfValues.get("val1")).isEqualTo(mapOfValues.get("val1"));
assertThat(readConverted.mapOfValues.get("val2")).isEqualTo(mapOfValues.get("val2"));
}