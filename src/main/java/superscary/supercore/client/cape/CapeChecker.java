package superscary.supercore.client.cape;

import net.minecraft.client.entity.AbstractClientPlayer;
import superscary.supercore.logging.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

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
@SuppressWarnings("unused")
public class CapeChecker
{

	/**
	 * Checks if the player has a cape attached to their UUID
	 *
	 * @param player the player to check
	 * @return true if there is a cape attached to their UUID
	 */
	public static boolean doesPlayerHaveCape(AbstractClientPlayer player)
	{

		String PLAYER_UUID = player.getUniqueID().toString();
		try
		{
			URL containerList = new URL(
					"https://raw.githubusercontent.com/SuperScary/WvsM/master/CAPES.txt");
			BufferedReader in = new BufferedReader(new InputStreamReader(containerList.openStream()));

			while (in.ready())
			{
				if (in.readLine().equals(PLAYER_UUID))
				{
					Logger.info("Cape for UUID: %s has been found!", PLAYER_UUID);
					return true;
				}
			}
		} catch (Exception e)
		{
			Logger.fatal(
					"Could not connect to the server. Please connect to the internet! Your cape will not be loaded.");
			return false;
		}
		return false;
	}

}
