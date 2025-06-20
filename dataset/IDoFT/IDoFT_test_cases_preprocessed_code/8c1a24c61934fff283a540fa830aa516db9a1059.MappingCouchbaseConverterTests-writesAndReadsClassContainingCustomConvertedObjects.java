@Test void writesAndReadsClassContainingCustomConvertedObjects(){
converter.setCustomConversions(new CouchbaseCustomConversions(converters));//RW
converter.afterPropertiesSet();//RW
converter.write(entity,converted);//RW
assertThat(converted.export().toString()).isEqualTo(source.export().toString());
CustomObjectEntity readConverted=converter.read(CustomObjectEntity.class,source);//RW
assertThat(readConverted.object.weight).isEqualTo(addy.weight);
assertThat(readConverted.listOfObjects.get(0).weight).isEqualTo(listOfObjects.get(0).weight);
assertThat(readConverted.mapOfObjects.get("obj0").weight).isEqualTo(mapOfObjects.get("obj0").weight);
assertThat(readConverted.mapOfObjects.get("obj1").weight).isEqualTo(mapOfObjects.get("obj1").weight);
}