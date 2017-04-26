package superscary.supercore.tools;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;

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
public class Register
{

	public static boolean clientEventHandler(Class cl)
	{
		MinecraftForge.EVENT_BUS.register(cl);
		return true;
	}

	public static boolean serverEventHandler(Class cl)
	{
		MinecraftForge.EVENT_BUS.register(cl);
		return true;
	}

	public static boolean block(Block block)
	{
		return register(block);
	}

	public static boolean item(Item item)
	{
		return register(item);
	}

	public static boolean itemStack(ItemStack stack)
	{
		return register(stack);
	}

	private static boolean register(Item item)
	{
		GameRegistry.register(item, item.getRegistryName());
		return true;
	}

	private static boolean register(Block block)
	{
		GameRegistry.register(block, block.getRegistryName());
		return true;
	}

	private static boolean register(ItemStack stack)
	{
		return register(stack.getItem());
	}

}
