@Test public void testC40EncodationSpecialCases1(){
assertEquals("230 91 11 91 11 91 11 91 11 91 11 91 11",visualized);
assertEquals("230 91 11 91 11 91 11 91 11 91 11 90 241",visualized);
assertEquals("230 91 11 91 11 91 11 91 11 91 11 254 66",visualized);
assertEquals("230 91 11 91 11 91 11 91 11 91 11 254 66 74 129 237",visualized);
assertEquals("230 91 11 91 11 91 11 66",visualized);
}