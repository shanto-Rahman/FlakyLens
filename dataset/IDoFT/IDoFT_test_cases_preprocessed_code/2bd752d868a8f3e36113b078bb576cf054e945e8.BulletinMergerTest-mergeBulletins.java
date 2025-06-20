@Test public void mergeBulletins() throws Exception {
assertEquals(bulletinEntities.size(),3);
assertTrue(bulletinEntities.contains(copyOfBulletin1));
assertEquals(copyOfBulletin1.getNodeAddress(),ALL_NODES_MESSAGE);
assertTrue(bulletinEntities.contains(bulletinEntity2));
assertTrue(bulletinEntities.contains(unauthorizedBulletin));
}