package superscary.supercore.client.cape;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

import java.util.ArrayList;
import java.util.List;

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
public class CapeFinder
{

	private List<ModContainer> modList = new ArrayList<>();

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		findAllCapes();
	}

	private void findAllCapes()
	{
		for (ModContainer mod : Loader.instance().getActiveModList())
		{
			for (Class c : mod.getClass().getInterfaces())
			{
				if (c.equals(ICoreMod.class))
				{
					modList.add(mod);
				}
			}
		}
	}

}
