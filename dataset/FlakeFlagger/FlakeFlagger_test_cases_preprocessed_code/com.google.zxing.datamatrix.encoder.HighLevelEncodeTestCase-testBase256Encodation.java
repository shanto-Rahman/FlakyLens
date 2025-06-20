@Test public void testBase256Encodation(){
assertEquals("231 44 108 59 226 126 1 104",visualized);
assertEquals("231 51 108 59 226 126 1 141 254 129",visualized);
assertEquals("231 44 108 59 226 126 1 141 36 147",visualized);
assertEquals("33 153 235 36 129",visualized);
assertEquals("231 51 108 59 226 126 1 104 99 153 53 129",visualized);
assertEquals("231 55 108 59 226 126 1 104 99 10 161 167 185 142 164 186 208" + " 220 142 164 186 208 58 129 59 209 104 254 150 45",visualized);
assertEquals("231 44 108 59 226 126 1 141 36 5 37 187 80 230 123 17 166 60 210 103 253 150",visualized);
assertEquals("231 63 108 59 226 126 1 141 36 5 37 187 80 230 123 17 166 60 210 103 1 129",visualized);
}