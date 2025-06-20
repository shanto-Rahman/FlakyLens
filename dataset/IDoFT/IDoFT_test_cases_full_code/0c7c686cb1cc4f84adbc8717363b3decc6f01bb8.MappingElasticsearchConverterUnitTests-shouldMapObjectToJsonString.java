@Test public void shouldMapObjectToJsonString(){
  Car car=new Car();
  car.setModel(CAR_MODEL);
  car.setName(CAR_NAME);
  String jsonResult=mappingElasticsearchConverter.mapObject(car).toJson();
  assertThat(jsonResult).isEqualTo(JSON_STRING);
}
