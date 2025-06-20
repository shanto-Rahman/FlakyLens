public void test_reserve3() throws Exception {
assertEquals("{\"player\":{\"name\":\"ljw\",\"id\":1001}}",JSONPath.reserveToObject(object,"player.id","player.name").toString());
assertEquals("{\"player\":{\"name\":\"ljw\",\"id\":1001}}",JSONPath.reserveToObject(object,"player.name","player.id","ab.c").toString());
}