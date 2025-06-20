public void testPlainCompare() throws Exception {
assertTrue(KeyValue.COMPARATOR.compare(aaa,bbb) < 0);
assertTrue(KeyValue.KEY_COMPARATOR.compare(keyabb,0,keyabb.length,keybbb,0,keybbb.length) < 0);
assertTrue(KeyValue.COMPARATOR.compare(bbb,aaa) > 0);
assertTrue(KeyValue.KEY_COMPARATOR.compare(keybbb,0,keybbb.length,keyabb,0,keyabb.length) > 0);
assertTrue(KeyValue.COMPARATOR.compare(bbb,bbb) == 0);
assertTrue(KeyValue.KEY_COMPARATOR.compare(keybbb,0,keybbb.length,keybbb,0,keybbb.length) == 0);
assertTrue(KeyValue.COMPARATOR.compare(aaa,aaa) == 0);
assertTrue(KeyValue.KEY_COMPARATOR.compare(keyabb,0,keyabb.length,keyabb,0,keyabb.length) == 0);
assertTrue(KeyValue.COMPARATOR.compare(aaa,bbb) > 0);
assertTrue(KeyValue.COMPARATOR.compare(bbb,aaa) < 0);
assertTrue(KeyValue.COMPARATOR.compare(aaa,aaa) == 0);
assertTrue(KeyValue.COMPARATOR.compare(aaa,bbb) < 0);
assertTrue(KeyValue.COMPARATOR.compare(bbb,aaa) > 0);
assertTrue(KeyValue.COMPARATOR.compare(aaa,aaa) == 0);
}