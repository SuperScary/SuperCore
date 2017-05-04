package superscary.supercore.render;

import net.minecraft.client.particle.Particle;
import net.minecraft.util.EnumParticleTypes;
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
public class Particular
{

	public static void spawnPartical(EnumParticleTypes particle, World world, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed, double zSpeed, int... parameters)
	{
		world.spawnParticle(particle, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed, parameters);
	}


	public static void spawnParticles(SuperParticle... particles)
	{
		SuperParticle particle;
		for (int i = 0; i < particles.length; i++)
		{
			particle = particles[i].getInstance();
			for (int j = 0; j < particle.getCount(); j++)
			{
				particles[i].getWorld().spawnParticle(particle.getTypes(), particle.getXCoord(), particle.getYCoord(), particle.getZCoord(), particle.getXSpeed(), particle.getYSpeed(), particle.getZSpeed(), particle.getParameters());
			}
		}
	}

	public class SuperParticle
	{

		private EnumParticleTypes types;
		private World world;
		private int count;
		private double xCoord;
		private double yCoord;
		private double zCoord;
		private double xSpeed;
		private double ySpeed;
		private double zSpeed;
		private int[] parameters;

		private Particle particle;

		public SuperParticle(EnumParticleTypes types, World world, int count, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed, double zSpeed, int... parameters)
		{
			this.types = types;
			this.world = world;
			this.count = count;
			this.xCoord = xCoord;
			this.yCoord = yCoord;
			this.zCoord = zCoord;
			this.xSpeed = xSpeed;
			this.ySpeed = ySpeed;
			this.zSpeed = zSpeed;
			this.parameters = parameters;

			this.particle = new Particle(world, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed);
		}

		public EnumParticleTypes getTypes()
		{
			return types;
		}

		public World getWorld()
		{
			return world;
		}

		public int getCount()
		{
			return count;
		}

		public double getXCoord()
		{
			return xCoord;
		}

		public double getYCoord()
		{
			return yCoord;
		}

		public double getZCoord()
		{
			return zCoord;
		}

		public double getXSpeed()
		{
			return xSpeed;
		}

		public double getYSpeed()
		{
			return ySpeed;
		}

		public double getZSpeed()
		{
			return zSpeed;
		}

		public int[] getParameters()
		{
			return parameters;
		}

		public Particle getParticle()
		{
			return particle;
		}

		public SuperParticle getInstance()
		{
			return this;
		}

	}

}
