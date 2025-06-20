@Test void writesAndReadsClassContainingCustomConvertedObjects(){
converter.setCustomConversions(customConversions);//RW
converter.afterPropertiesSet();//RW
((CouchbaseMappingContext)converter.getMappingContext()).setSimpleTypeHolder(customConversions.getSimpleTypeHolder());//RW
converter.write(entity,converted);//RW
assertThat(converted.export()).isEqualTo(source.export());
CustomObjectEntity readConverted=converter.read(CustomObjectEntity.class,source);//RW
assertThat(readConverted.object.weight).isEqualTo(addy.weight);
assertThat(readConverted.listOfObjects.get(0).weight).isEqualTo(listOfObjects.get(0).weight);
assertThat(readConverted.mapOfObjects.get("obj0").weight).isEqualTo(mapOfObjects.get("obj0").weight);
assertThat(readConverted.mapOfObjects.get("obj1").weight).isEqualTo(mapOfObjects.get("obj1").weight);
}