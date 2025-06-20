public void testGetIdentityLinksWithCandidateGroup(){
assertEquals(1,identityLinks.size());
assertEquals("muppets",identityLinks.get(0).getGroupId());
assertNull(identityLinks.get(0).getUserId());
assertEquals(IdentityLinkType.CANDIDATE,identityLinks.get(0).getType());
}