package superscary.supercore.gas;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

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
public abstract class Gas extends Fluid
{

	private float heatCapacity;
	private float heat;
	private float gravitationalConstant;

	private NBTTagCompound compound;

	public Gas(String fluidName, ResourceLocation still, ResourceLocation moving, float gravitationalConstant)
	{
		super(fluidName, still, moving);
		this.compound = new NBTTagCompound();
		this.gravitationalConstant = gravitationalConstant;
	}

	/**
	 * Only should be used is the still and moving images of the gas are the same
	 * @param fluidName
	 * @param location
	 * @param gravitationalConstant
	 */
	public Gas(String fluidName, ResourceLocation location, float gravitationalConstant)
	{
		this(fluidName, location, location, gravitationalConstant);
	}

	/**
	 * Writes the NBTTagCompound for this object
	 * @param compound
	 * @return
	 */
	public NBTTagCompound writeNBTTagCompound(NBTTagCompound compound)
	{
		this.compound = compound;

		compound.setFloat("HeatCapacity", getHeatCapacity());
		compound.setFloat("Heat", getHeat());
		compound.setFloat("GravitationalConstant", getGravitationalConstant());

		return compound;
	}

	/**
	 * Reads the NBTTagCompound for this object
	 * @param compound
	 * @return
	 */
	public NBTTagCompound readNBTTagCompound(NBTTagCompound compound)
	{
		heatCapacity = compound.getFloat("HeatCapacity");
		heat = compound.getFloat("Heat");

		return compound;
	}

	/**
	 * Sets the heat capacity of the gas
	 * @param par1Float
	 * @return
	 */
	public float heatCapacity(float par1Float)
	{
		this.heatCapacity = par1Float;
		return isAffectedByHeat() ? par1Float : -1F;
	}

	/**
	 * The heat capacity of the gas. Transformation happens when heat is at this level
	 * @return
	 */
	public float getHeatCapacity()
	{
		return heatCapacity;
	}

	/**
	 * The current heat of the gas
	 * @return
	 */
	public float getHeat()
	{
		return heat;
	}

	/**
	 * The constant that gravity affects the gasses ability to float
	 * @return
	 */
	public float getGravitationalConstant()
	{
		return gravitationalConstant;
	}

	/**
	 * Heats the gas
	 * @param heat the amount
	 * @param ticks the amount of time between each increment
	 */
	public void heat(float heat, int ticks)
	{

	}

	/**
	 * Cools the gas
	 * @param cool the amount
	 * @param ticks the amount of time between each decrement
	 */
	public void cool(float cool, int ticks)
	{

	}

	/**
	 * Whether or not the gas can be altered by heat (ex. the sun, lava, fire)
	 * @return
	 */
	public abstract boolean isAffectedByHeat();

	/**
	 * Can the gas be used as an oxygen supply or a breathable gas
	 * @return
	 */
	public abstract boolean isBreathable();

	/**
	 * Can the gas naturally dissipate?
	 * @return
	 */
	public abstract boolean canDissipate();

	/**
	 * Whether or not the gas can harm an entity (Different from {@link Gas#isBreathable()})
	 * @return true if entities can be harmed by the gas
	 */
	public abstract boolean isToxic();

	/**
	 * TODO: Create the tick handler
	 * Damages the entity if the gas is toxic
	 * @param entity
	 * @param damage
	 * @param ticks
	 */
	public void damageEntity(Entity entity, float damage, int ticks)
	{
		if (isToxic())
		{
			if (!entity.isDead)
			{

			}
		}
	}

}
