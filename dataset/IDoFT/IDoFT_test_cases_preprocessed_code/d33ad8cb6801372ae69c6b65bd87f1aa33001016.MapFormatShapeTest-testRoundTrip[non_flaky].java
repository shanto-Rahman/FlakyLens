public void testRoundTrip() throws Exception {
input.put(6,88);//IT
input.put(12,45);//IT
assertEquals(aposToQuotes("{'property':55,'map':{'6':88,'12':45}}"),json);
assertEquals(result.property,input.property);
assertEquals(input.getMap(),input.getMap());//IT
}