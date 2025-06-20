@Test public void shouldMapObjectToJsonString(){
car.setModel(CAR_MODEL);//IT
car.setName(CAR_NAME);//IT
assertThat(jsonResult).isEqualTo(JSON_STRING);
}