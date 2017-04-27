package superscary.supercore.gas;

import net.minecraft.util.EnumFacing;

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
public interface IGasContainer
{

	/**
	 * The gas to be stored within the container
	 * @return
	 */
	GasStack getGas();

	/**
	 * The maximum amount of gas allowed in the container
	 * @return
	 */
	float maxSize();

	/**
	 * Adds x amount of gas from the tank
	 * @param amount
	 * @return
	 */
	float add(float amount);

	/**
	 * Remove x amount of gas from the tank
	 * @param amount
	 * @return
	 */
	float remove(float amount);

	/**
	 * Buffer
	 * @return
	 */
	IGasContainer internalTank();

	/**
	 * The amount of gas contained within the container
	 * @return
	 */
	float getGasAmount();

	/**
	 * Is connected to a Transmitter
	 * @return
	 */
	boolean isConnected();

	/**
	 * Can be activated with redstone
	 * @return
	 */
	boolean redstoneActivated();

	/**
	 * The sides that a {@link GasTransmitter}, {@link IGasHandler}, or {@link IGasProvider} can connect to
	 * @return
	 */
	List<EnumFacing> deactivatedSides();

	/**
	 * If the tank can overflow. Input will stop if false.
	 * @return
	 */
	boolean canOverFlow();

	/**
	 * The amount of overflow until the tank starts to delete the excess. Only deletes if {@link IGasContainer#canPassthrough()}
	 * is false
	 * @return
	 */
	float overFlowAmount();

	/**
	 * If {@link IGasContainer#maxSize()} limit is met and there is a linked container through a gas network, it will push
	 * the excess through to the next available tank with the correct {@link Gas} or {@link GasStack}
	 * @return
	 */
	boolean canPassthrough();

}
