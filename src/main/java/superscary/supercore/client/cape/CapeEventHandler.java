package superscary.supercore.client.cape;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Copyright (c) 2017 by SuperScary(ERBF) http://codesynced.com
 * <p>
 * All rights reserved. No part of this software may be reproduced,
 * distributed, or transmitted in any form or by any means, including
 * photocopying, recording, or other electronic or mechanical methods,
 * without the prior written permission of the publisher, except in
 * the case of brief quotations embodied in critical reviews and
 * certain other noncommercial uses permitted by copyright law.
 */
@Mod.EventBusSubscriber
public class CapeEventHandler
{

	/**
	 * Checks if the players cape should be replaced with one from {@link superscary.supercore.SuperCore}
	 *
	 * @param event
	 */
	@SubscribeEvent
	public static void entityJoinWorld(EntityJoinWorldEvent event)
	{
		if (check(event))
		{
			CapeUtils.queuePlayerCapeReplacement((AbstractClientPlayer) event.getEntity());
		}
	}

	private static boolean check(EntityJoinWorldEvent event)
	{
		return event.getEntity() instanceof AbstractClientPlayer && CapeUtils
				.doesPlayerHaveCape((AbstractClientPlayer) event.getEntity());
	}

}
