package superscary.supercore.client.cape;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;
import superscary.supercore.logging.Logger;
import superscary.supercore.tools.ReflectionUtil;

import java.lang.invoke.MethodHandle;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static superscary.supercore.resources.ModResources.MODID;

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
@SuppressWarnings({"unused", "unchecked"})
class CapeUtils
{

	private static final ResourceLocation CAPE_LOCATION = new ResourceLocation(MODID,
			"textures/capes/wvsm.png");
	private static final UUID UUID_SUPERSCARY = UUID.fromString("d25f72fb-28d2-468a-a00c-feaad050368c");

	private static final ExecutorService THREAD_POOL = new ThreadPoolExecutor(0, 2, 1L, TimeUnit.MINUTES,
			new LinkedBlockingDeque<>());

	private static final MethodHandle GET_PLAYER_INFO = ReflectionUtil
			.findMethod(AbstractClientPlayer.class, "getPlayerInfo", "func_175155_b");
	private static final MethodHandle GET_PLAYER_TEXTURES = ReflectionUtil
			.findFieldGetter(NetworkPlayerInfo.class, "playerTextures", "field_187107_a");

	static void queuePlayerCapeReplacement(AbstractClientPlayer player)
	{
		final String displayName = player.getDisplayNameString();

		Logger.info("Queueing cape replacement for %s", displayName);

		THREAD_POOL.submit(() ->
		{
			try
			{
				Thread.sleep(100);
			} catch (InterruptedException e)
			{
				Logger.fatal(e, "Cape delay thread for %s interrupted", displayName);
				return;
			}

			Minecraft.getMinecraft().addScheduledTask(() -> replacePlayerCape(player));
		});
	}

	private static void replacePlayerCape(AbstractClientPlayer player)
	{
		final String displayName = player.getDisplayNameString();

		final NetworkPlayerInfo playerInfo;

		try
		{
			playerInfo = (NetworkPlayerInfo) GET_PLAYER_INFO.invokeExact(player);
		} catch (Throwable throwable)
		{
			Logger.fatal(throwable, "Failed to get NetworkPlayerInfo of %s", displayName);
			return;
		}

		if (playerInfo == null)
		{
			Logger.fatal("NetworkPlayerInfo of %s is null", displayName);
			return;
		}

		final Map<MinecraftProfileTexture.Type, ResourceLocation> playerTextures;
		try
		{
			playerTextures = (Map<MinecraftProfileTexture.Type, ResourceLocation>) GET_PLAYER_TEXTURES
					.invokeExact(playerInfo);
		} catch (Throwable throwable)
		{
			Logger.fatal(throwable, "Failed to get player textures of %s", displayName);
			return;
		}

		playerTextures.put(MinecraftProfileTexture.Type.CAPE, CAPE_LOCATION);
		Logger.info("Replaced cape of %s!", displayName);
	}

	static boolean doesPlayerHaveCape(AbstractClientPlayer player)
	{
		return player.getUniqueID().equals(UUID_SUPERSCARY) || CapeChecker.doesPlayerHaveCape(player);
	}

}
