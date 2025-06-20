@Test public void testEDIFACTEncodation(){
assertEquals("240 184 27 131 198 236 238 16 21 1 187 28 179 16 21 1 187 28 179 16 21 1",visualized);
assertEquals("240 184 27 131 198 236 238 98 230 50 47 47",visualized);
assertEquals("240 184 27 131 198 236 238 98 230 50 47 129",visualized);
assertEquals("240 184 27 131 198 236 238 98 230 50",visualized);
assertEquals("240 184 27 131 198 236 238 98 230 31",visualized);
assertEquals("240 184 27 131 198 236 238 98 231 192",visualized);
assertEquals("240 184 27 131 198 236 238 89",visualized);
assertEquals("240 185 134 24 185 134 24 185 134 24 185 134 24 185 134 24 185 134 24" + " 124 47 235 125 240" + " 97 139 152 97 139 152 97 139 152 97 139 152 97 139 152 97 139 152 89 89",visualized);
}