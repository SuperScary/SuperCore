package superscary.supercore.multiblock;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
public class MultiblockHandler
{

	private Block centralBlock;
	private Block[] connections;

	public MultiblockHandler(Block centralBlock, Block... connections)
	{
		this.centralBlock = centralBlock;
		this.connections = connections;
	}

	public Block getCentralBlock()
	{
		return centralBlock;
	}

	public Block[] getConnections()
	{
		return connections;
	}

	public int getConnectionCount()
	{
		return connections.length;
	}

	/**
	 * TODO: Get surrounding blocks to form the multiblock
	 * @param player
	 * @param world
	 * @param hand
	 * @param x
	 * @param y
	 * @param z
	 */
	public void onActivated(EntityPlayer player, World world, EnumHand hand, double x, double y, double z)
	{
		Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();

		if (block != null && block == this.centralBlock)
		{

		}
	}

	/**
	 * TODO: Create on destroy method (or make abstract?)
	 * @param player
	 * @param world
	 * @param hand
	 * @param x
	 * @param y
	 * @param z
	 */
	public void onDestroyed(EntityPlayer player, World world, EnumHand hand, double x, double y, double z)
	{

	}

	/**
	 * TODO: Create onPlaced method (or make abstract?)
	 * @param player
	 * @param world
	 * @param hand
	 * @param x
	 * @param y
	 * @param z
	 */
	public void onPlaced(EntityPlayer player, World world, EnumHand hand, double x, double y, double z)
	{

	}

}
