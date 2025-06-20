@Test public void parseEventCarPark() throws AdapterException {
assertEquals(6,parsedEvent.size());
assertEquals("{\"frei\":0,\"tendenz\":3,\"bezeichnung\":\"bahnhof.txt\",\"zeitstempel\":\"25.07.2018 10:45\",\"gesamt\":114,\"lfdnr\":1,\"status\":1}",parsedStringEvent);
}